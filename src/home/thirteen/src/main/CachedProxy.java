package home.thirteen.src.main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedProxy {
    private static final class Args{
        private final Method mMethod;
        private final Object[] mArgs;

        public Args(Method mMethod, Object[] mArgs) {
            this.mMethod = mMethod;
            this.mArgs = mArgs;
        }

        @Override
        public int hashCode() {
            int result = mMethod.hashCode();
            result = 31 * result + Arrays.hashCode(mArgs);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            final Args other = (Args) obj;
            if (!mMethod.equals(other.mMethod)) return false;
            for(int i = 0; i < mArgs.length; ++i){
                Object o1 = mArgs[i];
                Object o2 = other.mArgs[i];
                if(!(o1 == null ? o2 == null : o1.equals(o2))){
                    return false;
                }
            }
            return true;
        }
    }

    static private class myInvocationHandler<T> implements InvocationHandler {
        private T t;
        private final ConcurrentHashMap<Args, Object> argsToOutput = new ConcurrentHashMap<Args, Object>();

        public myInvocationHandler(T t) {
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Args input = new Args(method, args);
            ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
            if (argsToOutput.containsKey(input)){
                lock.readLock().lock();
                System.out.println("'"+ argsToOutput.get(input) + "' value from cache("+ args[0] + "," + args[1] +")");
                int resultSum = (int) argsToOutput.get(input);
                lock.readLock().unlock();
                return resultSum;
            }else {
                lock.writeLock().lock();
                Object result = method.invoke(t, args);
                System.out.println("save '" + result + "' to cache(" + args[0] + "," + args[1] + ")");
                argsToOutput.put(input, result);
                lock.writeLock().unlock();

                lock.readLock().lock();
                int resultSum = (int) argsToOutput.get(input);
                lock.readLock().unlock();
                return resultSum;
            }
        }
    }

    public static <T> T doCached(T t){
        Object cacheObject = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(), new myInvocationHandler<>(t));
        return (T) cacheObject;
    }
}

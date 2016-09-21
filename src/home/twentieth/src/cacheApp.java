package home.twentieth.src;

import java.lang.reflect.Proxy;

public class cacheApp {
    public static void main(String[] args) {
        Cachable fact = new FactImpl();
        Cachable factCache = (Cachable) Proxy.newProxyInstance(
                FactImpl.class.getClassLoader(),
                new Class[] { Cachable.class },
                new CachedProxy(fact));
        factCache.factorial(6);
    }
}

package home.twelfth.src.main.java.first;

import java.util.concurrent.Callable;

public class Task<T> {
    private Callable<? extends T> callable;
    private volatile T valueCall;
    private RuntimeException exception;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws Exception {
        if (valueCall == null && exception == null) {
            synchronized (callable) {
                if (valueCall == null && exception == null) {
                    try {
                        valueCall = callable.call();
                    } catch (Exception e) {
                        exception = new RuntimeException("new runtime exception!");
                    }
                }
            }
        }
        if (exception != null) throw exception;
        return valueCall;
    }
}


package com.sbt.lesson14;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyFutureRunnable extends FutureTask {
    public MyFutureRunnable(Callable callable){
        super(callable);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("From method");
    }
}

package com.sbt.lesson11;

public class ThrowExceptionSimpleClass implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try{
            Thread t = new Thread(new ThrowExceptionSimpleClass());
            Thread.setDefaultUncaughtExceptionHandler(((t1, e)
                    -> System.out.println("from thread " + t1.getName() + " err " + e.toString())));
            t.setUncaughtExceptionHandler(((t1, e)
                    -> System.out.println("MY from thread " + t1.getName() + " err " + e.toString())));
            t.start();
        } catch (Exception e){
            System.out.println("Handle exception");
        }
    }
}

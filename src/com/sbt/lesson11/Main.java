package com.sbt.lesson11;

public class Main {
    public static void main(String[] args) {
        /*SomeThread st = new SomeThread();
        st.start();
        System.out.println("end of main");
        new Thread(new Runnable() {
            public void run() {
                System.out.println("i'm here now");
            }
        }).start();*/
        SomeTask st = new SomeTask();
        Thread t1 = new Thread(st);
        t1.setPriority(Thread.MIN_PRIORITY);
        Thread t2 = new Thread(st);
        t2.setPriority(Thread.NORM_PRIORITY);
        Thread t3 = new Thread(st);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t3.start();
        t2.start();
    }
}

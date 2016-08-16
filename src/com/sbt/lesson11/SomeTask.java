package com.sbt.lesson11;

import java.util.ArrayList;

public class SomeTask implements Runnable {
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i< 5; i++) {
            System.out.println("st: "+Thread.currentThread().getName() + "(" + i +")");
        }
        //System.out.println();
    }

    public static void main(String[] args) {
        SomeTask st = new SomeTask();

        /*ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i<4; i++)
            threads.add(new Thread(st));
        threads.stream().forEach(Thread::start);*/
        /*Thread t = new Thread(st);
        t.setDaemon(true);
        t.start();*/
        Thread t = new Thread(st);
        t.start();
        System.out.println("1: "+t.isAlive());
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2: "+t.isAlive());
        System.out.println("end of main program");

    }
}

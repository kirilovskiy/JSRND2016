package com.sbt.lesson14;

import static com.sbt.lesson14.TaskTest.endGate;
import static com.sbt.lesson14.TaskTest.startGate;

public class LatchExample implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("before await");
            startGate.await();
            System.out.println("after await");
            try{
                System.out.println("Текущее состояние endGate.getCount(): "+ endGate.getCount());
//                Thread th = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("thread is going! " + Thread.currentThread().getName());
//                    }
//                });
//                th.start();
//                System.out.println("Текущее состояние endGate.getCount(): "+ Thread.currentThread().getState());
            } finally {
                endGate.countDown();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

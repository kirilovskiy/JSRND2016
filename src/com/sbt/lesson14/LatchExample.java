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

            } finally {
                endGate.countDown();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

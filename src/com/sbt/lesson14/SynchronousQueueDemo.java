package com.sbt.lesson14;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        final SynchronousQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread("PRODUSER") {
            public void run(){
                String event = "four";
                try{
                    queue.put(event);
                    System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        producer.start();

        Thread consumer = new Thread("CONSUMER") {
            public void run() {
                try {
                    String event = queue.take();
                    System.out.printf("[%s] consumed event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        consumer.start();
    }
}

package com.sbt.lesson14.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainSem {
    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet<Integer> set = new BoundedHashSet<>(3);
        ExecutorService ex = Executors.newFixedThreadPool(5);
        try{
            for(int i = 0; i < 10; i++){
                ex.execute(new AddToSet(i,set));
            }
//            set.remove(1);
            //Thread.sleep(100);
            System.out.println("----------------------");
        } finally {
            ex.shutdown();
        }
    }
}

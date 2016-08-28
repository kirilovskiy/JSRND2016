package com.sbt.lesson14.semaphore;

public class AddToSet implements  Runnable {
    private Integer i;
    private BoundedHashSet set;

    public AddToSet(Integer i, BoundedHashSet set) {
        this.i = i;
        this.set = set;
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + "Попытка добавить" + i);
            set.add(i);
            System.out.println(Thread.currentThread().getName() + "Успешно добавилось" + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

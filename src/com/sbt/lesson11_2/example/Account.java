package com.sbt.lesson11_2.example;

public class Account implements Runnable{
    private final Object myLock = new Object();
    private int saldo;

    public Account(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public synchronized void decreaseSaldo(int sum) {
        System.out.println("try decrease");
        synchronized (myLock){
        if (saldo - sum < 0) {
            System.err.println("Overdraft not awaylable!");
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saldo -= sum;
            System.out.println("Поток " + Thread.currentThread().getName() + " списал деньги = " + sum + ", осталось " + getSaldo());
        }
        }
    }

    @Override
    public void run() {
        int x = 12;
        for(int i = 0; i < x; i++){
            decreaseSaldo(10);
            if (getSaldo()<0) {
                throw new RuntimeException("current account overdrafted");
            }
        }
    }
}

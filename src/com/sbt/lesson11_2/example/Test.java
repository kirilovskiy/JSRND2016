package com.sbt.lesson11_2.example;

public class Test implements Runnable{
    private boolean endFlag = false;
    public void end(){
        setEndFlag(true);
    }

    public synchronized boolean isEndFlag() {
        return endFlag;
    }

    public synchronized void setEndFlag(boolean endFlag) {
        this.endFlag = endFlag;
    }

    public void run(){
        while(!isEndFlag()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}

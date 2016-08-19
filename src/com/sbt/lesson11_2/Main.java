package com.sbt.lesson11_2;

import com.sbt.lesson11_2.example.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*Account account = new Account(100);
        int x = 3;
        for (int i = 0; i < x; i++) {
            new Thread(account).start();
        }*/
/*      Square square = new Square(2,3,4);
        Thread t1 = new Thread(square);
        Thread t2 = new Thread(square);

        t1.start();
        t2.start();*/

        /*Test t = new Test();
        Thread t1 = new Thread(t);
        t1.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.end();
        System.out.println("End of main!");*/
/*      Date date1 = new Date();

        Man ivan = new Man("Ivan", date1);
        System.out.println(ivan.getDate());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        date1.setTime(new Date().getTime());
        ivan.getDate().setTime(new Date().getTime());
        System.out.println(ivan.getDate());*/

        /*Test t = new Test();
        Thread t1 = new Thread(t);
        t1.start();
        t1.interrupt();*/

        MonitorExample monitorExample = new MonitorExample();
        Thread tr = new Thread(monitorExample);
        tr.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        monitorExample.sendMessage("HELLO");
    }
}

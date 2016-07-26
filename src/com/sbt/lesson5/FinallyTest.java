package com.sbt.lesson5;

/*public class FinallyTest {
    public static void main(String[] args) {
        //System.out.println(f());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("I'm thread");
            }
        }
        }).start();
       int q = 1/0;
    }
}
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FinallyTest {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("c:\\1.txt");
            out = new FileOutputStream("c:\\2.txt");
            out.write(in.read());
        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            try {
                if (in != null){
                    in.close();
                }
            } catch (IOException e){
                //NOP
            }
            try {
                if (out != null){
                    out.close();
                }
            } catch (IOException e){
            //NOP
        }
        }


    }
}
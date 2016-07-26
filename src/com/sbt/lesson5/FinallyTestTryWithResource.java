package com.sbt.lesson5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FinallyTestTryWithResource {
    public static void main(String[] args) {
        try (
            FileInputStream in = new FileInputStream("c:\\1.txt");
            FileOutputStream out = new FileOutputStream("c:\\2.txt");
            ){
            out.write(in.read());
        } catch (IOException e) {
            System.out.println("File not found");
        }


    }
}
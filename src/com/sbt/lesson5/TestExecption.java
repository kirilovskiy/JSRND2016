package com.sbt.lesson5;

public class TestExecption {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println(count++);
        main(args);
    }
}

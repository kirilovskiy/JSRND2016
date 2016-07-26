package com.sbt.lesson5;

class MyException extends RuntimeException {
}

public class MyExceptionTest{
    public static void main(String[] args) {
        throw new MyException();

    }
}



package ru.sbertech.test.lesson3;

import ru.sbertech.test.lesson2.*;

public class SayHello {
    public static class Hello{
    public void Say(){
        System.out.println("Hello from lesson3");
    }
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.Say();
    }
}

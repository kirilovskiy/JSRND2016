package com.sbt.lesson5;

class Ok implements AutoCloseable {

    private String message;

    @Override
    public void close() throws Exception {
        System.out.println("Все ресурсы освобождены " + message);
    }

    public Ok(String s){
        this.message = s;
        System.out.println("I'm created");
    }
}


public class MyAutocloseable {
    public static void main(String[] args) throws Exception {
        try (Ok x = new Ok("x"); Ok y = new Ok("y")) {
            System.out.println("бизнес - логика сделана");
        }
    }
}

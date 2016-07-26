package com.sbt.lesson5;

class Engine {
    void startEngine(){
        System.out.println("Engine start");
    }
}

class Vehicle {
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startEngine(){
        engine.startEngine();
    }
}
public class NPE {
    public static void main(String[] args) {
        Engine engine = new Engine();

        Vehicle car =  new Vehicle();
        car.setEngine(engine);

        Vehicle bike = new Vehicle();
        bike.setEngine(engine);

        car.startEngine();
        //bike.startEngine();

        System.out.println("all engines adds"); // не выведится
    }
}

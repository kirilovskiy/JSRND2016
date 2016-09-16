package com.sbt.lesson19;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        MeteoStation meteo = new MeteoStation();
        Observer cons = new ConsoleObserver();

        meteo.addObserver(cons);
        meteo.setData(11,150);
    }
}

interface Observable{
    void notifyObserver(int temperature, int pressure);
    void addObserver(Observer o);
    void removeObserver(Observer o);
}

interface Observer{
    void onChange(int temperature, int pressure);
}

class MeteoStation implements Observable{
    List<Observer> observers = new ArrayList<>();
    int temperature;
    int pressure;

    void setData(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        this.notifyObserver(temperature, pressure);
    }

    @Override
    public void notifyObserver(int temperature, int pressure) {
        for(Observer observer : observers){
            observer.onChange(temperature,pressure);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}

class ConsoleObserver implements Observer{
    @Override
    public void onChange(int temperature, int pressure) {
        System.out.println("temp = " + temperature + " pres = " + pressure);
    }
}
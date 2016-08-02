package com.sbt.lesson7;

public class CalculatorImpl implements Calculator{

    @Override
    public void calc() {
        System.out.println("Calc from System classloader");
    }
}

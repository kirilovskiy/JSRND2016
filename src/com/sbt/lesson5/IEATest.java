package com.sbt.lesson5;

class SBTEmployee{
    public SBTEmployee(int grade){
        if ((grade < 0) || (grade > 16)) {
            throw new IllegalArgumentException();
        }
    }
}

public class IEATest {
    public static void main(String[] args) {
        SBTEmployee sbtEmployee1 = new SBTEmployee(2);
        SBTEmployee sbtEmployee2 = new SBTEmployee(20);
    }
}

package com.sbt.lesson11_2.example;

import java.util.Date;

public class Man {
    private final String name;
    private final Date date;

    public Man(String name, Date date) {
        this.name = name;
        this.date = new Date(date.getTime());
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }
}

package com.sbt.lesson9;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class DateAndTime implements Externalizable {
    static final long serialVersionUID = 0L;
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;
    private int seconds;

    public DateAndTime() {
        year = 2016;
        month = 10;
        day = 11;
        hours = 12;
        minutes = 12;
        seconds = 12;
    }

    @Override
    public String toString() {
        return "DateAndTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}

public class ExternalizableTest{

}

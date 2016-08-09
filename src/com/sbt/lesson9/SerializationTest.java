package com.sbt.lesson9;

import java.io.*;

//class Person implements Serializable{
//    private String firstName;
//    private int age;
//
//    public Person() {
//        this.firstName = "Mike";
//        this.age = 20;
//        System.out.println("person");
//    }
//}

class Student implements Serializable {
    private String group;
    private int avgMark;
    static final long serialVersionUID = -4255163576187673815L;

    public int getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(int avgMark) {
        this.avgMark = avgMark;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student() {
        group = "default";
        avgMark = 3;
    }

    @Override
    public String toString() {
        return "Student{ group = '" + group + "'; avgMark = " + avgMark+" }";
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        avgMark = avgMark ^ 0xFFFFFFFF;
        out.defaultWriteObject();
        out.writeLong(System.currentTimeMillis());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        avgMark = avgMark ^ 0xFFFFFFFF;
        long value = in.readLong();
        System.out.println(value);
    }
}

public class SerializationTest {
    public static void main(String[] args) throws IOException {
        String fileName = "c:\\1\\student.bin";
//        Student student = new Student();
//        System.out.println(student);
//        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            fout.writeObject(student);
//        }

//        Student student1;
//
//        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(fileName))) {
//            student1 = (Student) fin.readObject();
//            System.out.println(student1);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        DateAndTime dateAndTime1 = new DateAndTime();
        System.out.println(dateAndTime1);
        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(fileName))) {
            fout.writeObject(dateAndTime1);
        }

        DateAndTime dateAndTime;

        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(fileName))) {
            dateAndTime = (DateAndTime) fin.readObject();
            System.out.println(dateAndTime);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

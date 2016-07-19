package com.sbt.examples;

import com.sbt.Person;
import com.sbt.PersonFirstLoad;

import java.util.LinkedList;

public class Example2_LinkedList {
    public static void main(String[] args) {
        LinkedList<Person> persons =  new LinkedList<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        System.out.println("-----------------------------------");
        System.out.println((persons).peek());
        System.out.println("-----------------------------------");
        System.out.println((persons).poll());
        System.out.println("-----------------------------------");
        persons.poll();
        persons.poll();
        persons.poll();
        System.out.println(persons.poll());
        System.out.println(persons.peek());
        System.out.println("-----------------------------------");
        persons.pollLast();
        PersonFirstLoad.print(persons);

    }
}


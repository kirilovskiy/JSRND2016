package com.sbt.lesson3.examples;

import com.sbt.lesson3.Person;
import com.sbt.lesson3.PersonFirstLoad;

import java.util.HashSet;
import java.util.Set;

public class Example3_Set {
    public static void main(String[] args) {
        Set<Person> persons =  new HashSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        System.out.println(persons.size());
    }
}

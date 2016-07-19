package com.sbt.examples;

import com.sbt.Person;
import com.sbt.PersonFirstLoad;

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

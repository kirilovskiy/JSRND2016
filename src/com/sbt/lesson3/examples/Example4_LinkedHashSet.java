package com.sbt.lesson3.examples;

import com.sbt.lesson3.PersonFirstLoad;
import com.sbt.lesson3.Person;

import java.util.LinkedHashSet;
import java.util.Set;


public class Example4_LinkedHashSet {
    public static void main(String[] args) {
        Set<Person> persons =  new LinkedHashSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        //System.out.println(persons.size());
    }
}

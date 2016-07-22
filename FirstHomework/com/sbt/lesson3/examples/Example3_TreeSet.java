package com.sbt.lesson3.examples;

import com.sbt.lesson3.PersonFirstLoad;
import com.sbt.lesson3.Person;

import java.util.Set;
import java.util.TreeSet;

public class Example3_TreeSet {
    public static void main(String[] args) {
        Set<Person> persons =  new TreeSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        //System.out.println(persons.size());
    }
}

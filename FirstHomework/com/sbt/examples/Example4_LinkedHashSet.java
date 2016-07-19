package com.sbt.examples;

import com.sbt.Person;
import com.sbt.PersonFirstLoad;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class Example4_LinkedHashSet {
    public static void main(String[] args) {
        Set<Person> persons =  new LinkedHashSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        //System.out.println(persons.size());
    }
}

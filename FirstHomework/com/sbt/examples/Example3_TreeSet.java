package com.sbt.examples;

import com.sbt.Person;
import com.sbt.PersonFirstLoad;

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

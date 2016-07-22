package com.sbt.lesson3.examples;

import com.sbt.lesson3.PersonFirstLoad;
import com.sbt.lesson3.Person;

import java.util.HashMap;
import java.util.Map;

public class Example5_Map {
    public static void main(String[] args) {
        Map<String, Person> persons = new HashMap<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        System.out.println(persons.size());
        System.out.println(persons.get("15"));

    }
}

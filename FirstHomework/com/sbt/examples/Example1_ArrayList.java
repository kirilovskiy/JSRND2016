package com.sbt.examples;

import com.sbt.Person;
import com.sbt.PersonFirstLoad;

import java.util.ArrayList;
import java.util.List;

public class Example1_ArrayList {
    public static void main(String[] args) {
        List<Person> persons =  new ArrayList<Person>();
        PersonFirstLoad.init(persons);
        /*PersonFirstLoad.print(persons);

        System.out.println(persons.get(10));
        List<Person> subPersons = persons.subList(10,15);
        System.out.println("----------------------------------------------");
        PersonFirstLoad.print(subPersons);

        System.out.println("----------------------------------------------");
        subPersons.add(new Person(27L, "Бирюков Виктор Валерьевич", "89515151511"));
        System.out.println(persons.containsAll(subPersons));*/
        System.out.println(persons.contains(new Person(10L, "Бирюков Виктор Валерьевич", "89515151511")));
    }
}

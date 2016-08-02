package com.sbt.lesson7;


import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        /*URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {new URL("file:/J:/lecture7/Person.jar")});
        Class<?> percClazz = urlClassLoader.loadClass("ru.sbt.bvv.lecture7.Person1");
        Method m = percClazz.getDeclaredMethod("info");
        m.invoke(percClazz.newInstance());*/

        /*Person person = (Person) percClazz.newInstance();*/

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {new URL("file:/J:/lecture7/Person.jar")});

        Class<?> calcClazz = urlClassLoader.loadClass("ru.sbt.bvv.lecture7.CalculatorImpl");
        ((Calculator) calcClazz.newInstance()).calc();

        Calculator calculator = new CalculatorImpl();
        calculator.calc();

    }
}

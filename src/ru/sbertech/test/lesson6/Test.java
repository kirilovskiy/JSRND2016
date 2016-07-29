package ru.sbertech.test.lesson6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*try {
            System.out.println(A.class.getMethod("pA", String.class));
            System.out.println(A.class.getDeclaredMethod("prA", String.class));
            System.out.println(C.class.getDeclaredField("aC"));
            System.out.println(C.class.getSuperclass());
        } catch (NoSuchMethodException e) {
            System.out.println("Not exists such method!");
        } catch (NoSuchFieldException e) {
            System.out.println("Not exists such field!");
        }

        Class clazz = C.class;
        while (clazz != null) {
            System.out.println(clazz);
            clazz = clazz.getSuperclass();
        }*/
/*
        try {
            Method m = A.class.getDeclaredMethod("prA", String.class);
            m.setAccessible(true);
            m.invoke(A.class.newInstance(), "TEXT");
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
*/
  /*      try {
            Field f = C.class.getDeclaredField("aC");
            f.setAccessible(true);
            if (f.isAnnotationPresent(ValidLength.class)){
                System.out.println("Annotation is it " + f.getAnnotation(ValidLength.class));
                ValidLength validLength = f.getAnnotation(ValidLength.class);

                if (validLength.value() != ((String) f.get(C.class.newInstance())).length()) {
                    System.out.println("Внимание длина не равна!");
                } else {System.out.println("Все ОК0!");}

            }
        } catch (NoSuchFieldException e) {
            System.out.println("Нет поля!");
        } catch (InstantiationException e) {
            System.out.println("Не можем создать экземпляр класса!");
        } catch (IllegalAccessException e) {
            System.out.println("Не можем получить доступ!");
        }*/


        List<String> list = new ArrayList<>();
        List<String> loggedlist = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                                        list.getClass().getInterfaces(),
                                        new InvocationHandlerImpl(list));
        loggedlist.add("first");
        System.out.println(loggedlist.get(0));
        System.out.println(loggedlist.remove(0));
        System.out.println(loggedlist.size());
    }
}

package ru.sbertech.test.Lesson4;

public class B extends A {
    public static <T> String getType(T obj){
        return obj.getClass().getName();
    }

}

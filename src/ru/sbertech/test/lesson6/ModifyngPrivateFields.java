package ru.sbertech.test.lesson6;

import java.lang.reflect.Field;

class WithPrivateFinalField {
    private int i = 1;
    private final String s = "String S";
    private String s2 = "String S2";

    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}

public class ModifyngPrivateFields {

    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(pf, 47);
        System.out.println(pf);

        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        f.set(pf, "MODIFY S");
        System.out.println(pf);


        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        f.set(pf, "MODIFY S2");
        System.out.println(pf);
    }
}

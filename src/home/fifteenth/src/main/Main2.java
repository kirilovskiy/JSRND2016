package main;

import java.util.HashSet;

public class Main2 {
    private static final int MaxSize = 10000000;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        for (int i = 0; i < MaxSize; i++) {
            addObjects();
        }
        System.out.println("added items: " + set.size());
    }
    private static void addObjects(){
        Object o = new Main1();
            set.add(o.toString());
    }

}

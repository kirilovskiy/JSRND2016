package main;

import java.util.HashMap;

public class Main1 {
    public static void main(String[] args) {
        int MaxSize = 100000;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < MaxSize; i++) {
            map.put(i, "value" + i);
        }
    }
}

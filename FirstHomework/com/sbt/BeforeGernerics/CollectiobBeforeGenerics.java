package com.sbt.BeforeGernerics;

import java.util.ArrayList;

public class CollectiobBeforeGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList();

        for(int i = 0; i < 3; i++){
            apples.add(new Apple());
        }

        //apples.add(new Orange());
        for(int i = 0; i < 3; i++){
            System.out.println(apples.get(i).getId());
        }
    }
}

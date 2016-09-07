package home.sixteenth.src.main.java.longmethod.bad;

import java.util.Random;

public class Main {

    public static void printMaxInMas(){
        Random random = new Random();
        int[] mas = new int[random.nextInt(100)];
        for(int i = 0; i < mas.length; i++ ){
            mas[i] = random.nextInt(100);
        }
        int max = mas[0];
        for(int i = 1; i < mas.length; i++)
            if (mas[i]>max)	max=mas[i];
        System.out.println("max = " + max);
    }

    public static void main(String[] args) {
        printMaxInMas();
    }
}

package home.sixteenth.src.main.java.longmethod.good;

import java.util.Random;

public class Main {

    public static void printMaxInMas(){
        int[] mas = initMas();
        int max = findMax(mas);
        printMax(max);
    }

    public static int[] initMas(){
        Random random = new Random();
        int[] mas = new int[random.nextInt(100)];
        for(int i = 0; i < mas.length; i++ ){
            mas[i] = random.nextInt(100);
        }
        return mas;
    }

    public static int findMax(int[] mas){
        int max = mas[0];
        for(int i = 1; i < mas.length; i++)
            if (mas[i]>max)	max=mas[i];
        return max;
    }

    public static void printMax(int max){
        System.out.println("max = " + max);
    }

    public static void main(String[] args) {
        printMaxInMas();
    }
}

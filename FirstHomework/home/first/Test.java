package home.first;

import java.io.*;
import java.util.Random;

public class Test
{
    public static final class mymethods{
        static Random random = new Random();

        public static int method_2002(int max){
            int n = random.nextInt(max);
            int[] mas =  new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++ ){
                mas[i] = random.nextInt(max);
                sum += mas[i];
            }
            return sum;
        }

        public static int method_2003(int max){
            int n = random.nextInt(max);
            int[] mas =  new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++ ){
                mas[i] = random.nextInt(max);
                if (i % 2 == 0)
                    sum -= mas[i];
                else
                    sum += mas[i];
            }
            return sum;
        }

        public static int method_2004(){
            int n = random.nextInt(2100-1100)+1100;
            if (((n % 4 == 0) && (n % 100 != 0))||(n % 400 == 0))
                return 1;
            else
                return 0;
        }

        public static int method_2005(int max){
            int n = random.nextInt(max);
            int[] mas =  new int[n];
            for(int i = 1; i < n; i++ ){
                mas[i] = random.nextInt(max)-max;
            }
            int num = 0, min = mas[0];
            for(int i = 1; i < mas.length; i++ ){
                if (mas[i] < min) {
                    min = mas[i];
                    num = i;
                }
            }
            return num;
        }

        public static void method_2006(int l){
            int koldm = l/3;
            if (l % 3 == 2) koldm++;
            System.out.println("count of ft = "+ koldm/12 + " count of inch = " + koldm%12);
        }

    }


    public static void main(String[] args) throws IOException {
        System.out.println(mymethods.method_2002(10000));
        System.out.println(mymethods.method_2003(10000));
        System.out.println(mymethods.method_2004());
        System.out.println(mymethods.method_2005(10000));
        mymethods.method_2006(74);
    }

}
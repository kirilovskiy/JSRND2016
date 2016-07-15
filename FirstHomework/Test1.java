
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test1
{
    public static final class mymethods{
        static Random random = new Random();

        // for method_2021
        public static void max(int[] mas){
            int max = mas[0];
            for(int i = 1; i < mas.length; i++)
                if (mas[i]>max)	max=mas[i];
            for(int i = 0; i < mas.length; i++ ){
                if (mas[i]==max) mas[i]=mas[i]/2;
            }

        }

        public static void print(int[] mas){
            for(int i = 0; i < mas.length; i++ ){
                System.out.print(mas[i]+" ");
            }
            System.out.println();
        }
        // for method_2023
        public static void print(ArrayList<Integer> list){
            for(int i = 0; i < list.size(); i++ ){
                System.out.print(list.get(i) +" ");
            }
            System.out.println();
        }

        public static void print(String[] mas){
            for(int i = 0; i < mas.length; i++ ){
                System.out.println(mas[i]);
            }
        }

        public static void method_2021(){
            int[] mas = new int[random.nextInt(100)];
            for(int i = 0; i < mas.length; i++ ){
                mas[i] = random.nextInt(100);
            }
            max(mas);
            max(mas);
            print(mas);
        }

        public static int method_2022(){
            int cnt = 0;
            int[] mas = new int[random.nextInt(100)];
            for(int i = 0; i < mas.length; i++ ){
                mas[i] = random.nextInt(100);
            }
            for(int i = 0; i < mas.length; i++ ){
                for(int j = 0; j < mas.length; j++ ){
                    if ((i != j)&&(mas[j]!=0)&&(mas[i]%mas[j]==0))
                        cnt++;
                }
            }
            return cnt;
        }

        public static void method_2023(int max){
            int[] a = new int[random.nextInt(max)];
            int[] b = new int[random.nextInt(max)];
            ArrayList<Integer> c = new ArrayList<Integer>();
            for(int i = 0; i < a.length; i++ ){
                a[i] = random.nextInt(max);
            }
            for(int i = 0; i < b.length; i++ ){
                b[i] = random.nextInt(max);
            }

            for(int i = 0; i < a.length; i++ ){
                for(int j = 0; j < b.length; j++ ){
                    if (a[i]==b[j]){
                        c.add(a[i]);
                        break;
                    }
                }
            }
            if (c.size()==0)
                System.out.println(0);
            else {
                System.out.println(c.size());
                print(c);
            }
        }

        public static void method_2024(){
            int cnt=0;
            int[] mas = new int[random.nextInt(100)];
            for(int i = 0; i < mas.length; i++ ){
                mas[i] = random.nextInt(100);
            }
            for(int i = 0; i < mas.length/2; i++ ){
                //System.out.println("mas[i]="+mas[i]+"mas[mas.length-i-1]="+mas[mas.length-i-1]);
                if (mas[i]!=mas[mas.length-i-1]) cnt++;
            }
            System.out.println(cnt);
        }

        public static void method_2036(){
            String[] mas = new String[6]; // new String[random.nextInt(100)];
            int cnt=0;
            System.out.println("Please input "+mas.length+" strings");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for(int i = 0; i < mas.length; i++){
                try {
                    mas[i]=reader.readLine().toLowerCase();
                    if (mas[i].length()>20)
                        mas[i]=mas[i].substring(0, 19);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 0; i < mas.length; i++){
                cnt=0;
                for(char ch : mas[i].toCharArray()){
                    switch(ch){
                        case 'e':
                        case 'y':
                        case 'u':
                        case 'i':
                        case 'o':
                        case 'a': { cnt++; break;}
                        default: {cnt=0; break;}
                    }
                    if (cnt==3) break;
                }
                if (cnt<3)
                    System.out.println(mas[i]);
            }
        }

        public static void method_2038(){
            String s = new String("GvJ8n");
            ArrayList<String> tmp = new ArrayList<String>();
            int i = 0, max = 0;
            for (int j = 0; j < s.length(); j++) {
                if (!Character.isLetter(s.charAt(j))) {
                    if (j > i) tmp.add(s.substring(i, j));
                    i = j + 1;
                }
            }
            if (i < s.length()) {
                tmp.add(s.substring(i));
            }
            for(String t: tmp){
                if (t.length()>max)
                    max=t.length();
            }
            System.out.println(max);

        }

        // for method_2053
        public static String[] divide_str(String s) {
            ArrayList<String> tmp = new ArrayList<String>();
            int i = 0;
            for (int j = 0; j < s.length(); j++) {
                if ((s.charAt(j) == ' ')||(s.charAt(j) == '\n')) {
                    if (j > i) tmp.add(s.substring(i, j));
                    i = j + 1;
                }
            }
            if (i < s.length()) {
                tmp.add(s.substring(i));
            }
            return tmp.toArray(new String[tmp.size()]);
        }

        public static void method_2053(){
            String s = new String("a aa aaa aaaa\na aa aaa bbbb");
            String[] strs = divide_str(s);
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(String s1 : strs){
                if (!map.containsKey(s1)){
                    map.put(s1, map.size()+1);
                }
            }
            for(String s1 : strs){
                System.out.print(map.get(s1)+" ");
            }
        }
        
    }


    public static void main(String[] args) throws IOException {
		mymethods.method_2021();
		System.out.println(mymethods.method_2022());
		mymethods.method_2023(10000);
		mymethods.method_2024();
		mymethods.method_2036();
        	mymethods.method_2038();
        	mymethods.method_2053();
    }

}
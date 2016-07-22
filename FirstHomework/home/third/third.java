package home.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class third {

    public static ArrayList<String> divide_str(String[] str){
            ArrayList<String> tmp = new ArrayList<String>();
            for(String s : str){
                tmp.add(s);
            }
            return tmp;
        }

    public static void print(Collection<String> str){
        Iterator<String> iterator = str.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public class ReverseIterator<T> implements Iterator<T>, Iterable<T> {

        private final List<T> list;
        private int position;

        public ReverseIterator(List<T> list) {
            this.list = list;
            this.position = list.size()-1;
        }

        @Override
        public Iterator<T> iterator() { return this; }

        @Override
        public boolean hasNext() { return position>=0; }

        @Override
        public T next() { return this.list.get(this.position--);}

        @Override
        public void remove() {
        }
    }

    public static void task_2(Set<String> setl){
        //Отсортированный список разных слов по длине и затем по тексту
        System.out.println("---------------task 2---------------------");
        TreeSet<String> sotredset = new TreeSet<String>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return ((s1.length()-s2.length()) < 0 ? -1 : (s1.length()-s2.length()) > 0 ? 1 : s1.toString().compareTo(s2.toString()));
            }
        });
        sotredset.addAll(setl);
        print(sotredset);
        System.out.println("sotredset.size()="+sotredset.size());
    }

    public static void task_3(Collection<String> setl,Collection<String> arl){
        //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        System.out.println("-----------------task 3-------------------");
        int cnt;
        for(String s : setl){
            cnt=0;
            for(String s2 : arl){
                if (s.equals(s2)) cnt++;
            }
            System.out.println("element {"+s+"} occurs "+cnt+"times");
        }
    }

    public static void task_4(List<String> lines){
        //Задание 4: Выведите на экран все строки файла в обратном порядке.
        System.out.println("-----------------task 4-------------------");
        for(int i = lines.size()-1; i>=0; i--){
            System.out.println(lines.get(i));
        }
    }

    public static void task_5(List<String> lines){
        System.out.println("----------------task 5--------------------");
        Iterator<String> it = new third().new ReverseIterator<String>(lines).iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void task_6(List<String> lines) throws IOException {
        System.out.println("----------------task 6--------------------");
        System.out.println("Input numbers with character ' ' between them");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String[] nums = reader.readLine().split(" +");
            for (String num : nums) {
                if (Integer.valueOf(num) < lines.size())
                    System.out.println(lines.get(Integer.valueOf(num)));
                else System.out.println("Index out of bounds");
            }
        }

    }

    public static void main(String[] args) throws IOException{
        //все строки
        List<String> lines = Files.readAllLines(Paths.get("C:\\1\\1.txt"), Charset.forName("Cp1251"));
        ArrayList<String> arl = new ArrayList<String>(); // для всех слов
        Set<String> setl = new HashSet<String>(); // для уникальных слов
        // переделать в Map - будет быстрее и красивее работать
        for(String s : lines){
            arl.addAll(divide_str(s.split("[\\s\\p{Punct}]+")));
            setl.addAll(divide_str(s.split("[\\s\\p{Punct}]+")));
        }
        System.out.println("---------------task 1---------------------");
        System.out.println("setl.size()="+setl.size());
        task_2(setl);
        task_3(setl,arl);
        task_4(lines);
        task_5(lines);
        task_6(lines);
    }
}

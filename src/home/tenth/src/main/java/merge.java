package home.tenth.src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class merge {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList(Arrays.asList("abc","cba","aaa","sfd"));
        List<String> l2 = new ArrayList(Arrays.asList("aa","abc","acbb","AAA","ABC","df"));

        mergeLists<List<String>, List<String>> merge = (a,b)-> {
            List<String> twoLists = new ArrayList(a);
            twoLists.addAll(b);
            return twoLists;
        };
        //соединяем два массива
        List<String> mergeList = merge.mergeList(l1,l2);
        mergeList.forEach(System.out::println);
        System.out.println("--------------------------------------");
        boolean anyA = mergeList
                .stream()
                .anyMatch(v->v.startsWith("a"));
        if (anyA) System.out.println("list has elements start with 'a'");
            else System.out.println("list hasn't elements start with 'a'");
        System.out.println("--------------------------------------");
        long startWithA =  mergeList
                .stream()
                .filter(v->v.startsWith("a"))
                .distinct()
                .count();
        System.out.println("cnt string starts with literal 'a' = " + startWithA);
        System.out.println("--------------------------------------");
        System.out.println("the first three lines: ");
        mergeList.stream()
                .filter(v->v.startsWith("a"))
                .distinct()
                .sorted()
                .limit(3) //всего будет 4е после фильтрации
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
        System.out.println("max length value");
        mergeList
                .stream()
                .map(s -> s.length())
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);
        System.out.println("--------------------------------------");
        System.out.println("average length value");
        System.out.println(mergeList.stream().collect(Collectors.averagingInt(p -> p.length())));
    }
}

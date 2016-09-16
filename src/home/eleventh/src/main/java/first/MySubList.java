package home.eleventh.src.main.java.first;

import java.util.List;
import java.util.stream.Collectors;

public class MySubList {
    List<String> list;

    public MySubList(List<String> list) {
        this.list = list;
    }

    public int countLetters(){
        return list
                .stream()
                .collect(Collectors
                        .summingInt(i ->
                        {
                            int sum = 0;
                                for (int j = 0; j < i.length(); j++) {
                                    sum += Character.isLetter(i.charAt(j)) ? 1 : 0;
                                }
                            return sum;
                        }));
    }
}

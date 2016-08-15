package home.tenth.src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class convert {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(0,2,3,45));
        list
            .stream()
            .map((l1) -> {Converter<Integer, String> converter = (fr) -> String.valueOf(fr) + " dollars";
                          return converter.convert(l1);})
            .forEach(System.out::println);

    }
}

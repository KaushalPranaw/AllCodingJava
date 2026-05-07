package May2026.Java8Stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        //Input: {"aa", "bb", "aa", "cb", "bb"}
        //Output: {a=2} {b=2} {a=2} {c=1, b=1} {b=2}

        List<String> list = Arrays.asList("aa", "bb", "aa", "cb", "bb");
        list.stream()
                .map(str -> str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                ).forEach(System.out::println);
    }
}

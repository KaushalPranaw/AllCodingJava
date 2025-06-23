package Comp.GSGR_PMW3;

import java.util.*;
import java.util.stream.Collectors;

public class Problem12_GroupAnagram {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("cat", "dog", "god");
        Set<Set<String>> result = group(input);
        System.out.println(result); // Output: [[cat], [dog, god]]
    }

    private static Set<Set<String>> group(List<String> input) {
        /*return new HashSet<>(
                input.stream()
                        .collect(Collectors.groupingBy(
                                word -> {
                                    char[] ca = word.toCharArray();
                                    Arrays.sort(ca);
                                    return new String(ca);
                                },
                                Collectors.toCollection(HashSet::new)
                        ))
                        .values()
        );*/

        return new HashSet<>(input.stream().collect(Collectors.groupingBy(
                word -> {
                    char[] ca = word.toCharArray();
                    Arrays.sort(ca);
                    return new String(ca);
                }, Collectors.toSet())
        ).values());

    }
}

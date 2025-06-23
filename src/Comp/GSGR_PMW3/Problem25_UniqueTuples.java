package Comp.GSGR_PMW3;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem25_UniqueTuples {
    public static void main(String[] args) {
        // Test cases
        System.out.println(uniqueTuples("abbccde", 2)); // Output: [ab, bb, bc, cc, cd, de]
        System.out.println(uniqueTuples("abc", 3));     // Output: [abc]
        System.out.println(uniqueTuples("abc", 4));     // Output: []
        System.out.println(uniqueTuples("", 2));        // Output: []
        System.out.println(uniqueTuples("aaaa", 2));    // Output: [aa]
    }

    public static HashSet<String> uniqueTuples(String input, int len) {
        /*HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= input.length() - len; i++) {
            set.add(input.substring(i, i + len));
        }
        return set;*/

        return IntStream.range(0, input.length() - len + 1)
                .mapToObj(i -> input.substring(i, i + len))
                .collect(Collectors.toCollection(HashSet::new));
    }

    /*public static HashSet<String> uniqueTuples(String input, int len) {
        HashSet<String> result = new HashSet<>();

        // Edge case: If input is null or len is greater than the string length
        if (input == null || len > input.length() || len <= 0) {
            return result; // Return an empty HashSet
        }

        // Sliding window to extract substrings of length 'len'
        for (int i = 0; i <= input.length() - len; i++) {
            String tuple = input.substring(i, i + len);
            result.add(tuple);
        }
        return result;
    }*/
}

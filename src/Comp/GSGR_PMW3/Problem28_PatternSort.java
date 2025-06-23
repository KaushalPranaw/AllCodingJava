package Comp.GSGR_PMW3;

import java.util.HashMap;
import java.util.Map;

public class Problem28_PatternSort {
    public static void main(String[] args) {
        String input = "abc";
        String pattern = "bac";

        String sortedString = sortByPattern(input, pattern);
        System.out.println("Original string: " + input);
        System.out.println("Sorted according to pattern '" + pattern + "': " + sortedString);
    }

    private static String sortByPattern(String input, String pattern) {
        // Create a priority map based on the pattern
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            //bac
            //b->0, a->1, c->2
            map.put(pattern.charAt(i), i);
        }

        // Convert input string to character array
        char[] chars = input.toCharArray();

        // Bubble sort implementation based on pattern priorities
        int n = chars.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int priority1 = map.getOrDefault(chars[j], Integer.MAX_VALUE);
                int priority2 = map.getOrDefault(chars[j + 1], Integer.MAX_VALUE);

                if (priority1 > priority2) {
                    // Swap characters
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }
}

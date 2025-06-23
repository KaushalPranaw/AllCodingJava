package Leetcode.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        //put t occurence in map
        Map<Character, Long> map = t.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int tlen = t.length();

        int start = 0, end = 0;
        int ansIndex = 0, ansLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                long count = map.get(eChar);
                if (count > 0) {
                    tlen--;
                }
                map.put(eChar, count - 1);
            }
            end++;

            while (tlen == 0) {
                if (ansLen > end - start) {
                    ansLen = end - start;
                    ansIndex = start;
                }

                char sChar = s.charAt(start);
                if (map.containsKey(sChar)) {
                    long count = map.get(sChar);
                    if (count == 0) {
                        tlen++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansIndex, ansIndex + ansLen);
    }
}

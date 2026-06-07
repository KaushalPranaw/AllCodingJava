package Leetcode.Leetcode150.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        int start = 0, end = 0;
        int ansIndex = 0, ansLen = Integer.MAX_VALUE;
        int tLen = t.length();

        //cal t occurrence
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (end < s.length()) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                int count = map.get(eChar);
                if (count > 0) {
                    tLen--;
                }
                map.put(eChar, count - 1);
            }
            end++;

            while (tLen == 0) {
                //cal minLen
                if (ansLen > end - start) {
                    ansLen = end - start;
                    ansIndex = start;
                }

                //update schar
                char sChar = s.charAt(start);
                if (map.containsKey(sChar)) {
                    int count = map.get(sChar);
                    if (count == 0) {
                        tLen++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansIndex, ansIndex + ansLen);
    }
}
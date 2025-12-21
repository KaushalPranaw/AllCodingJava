package Leetcode.Leetcode150.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }

        //t occurance
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0, end = 0;
        int charTLeft = t.length();
        int ansIndex = 0;
        int ansLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                int count = map.get(eChar);
                if (count > 0) {
                    charTLeft--;
                }
                map.put(eChar, count - 1);
            }
            end++;

            while (charTLeft == 0) {
                if (ansLen > end - start) {
                    ansIndex = start;
                    ansLen = end - start;
                }
                char sChar = s.charAt(start);
                if (map.containsKey(sChar)) {
                    int count = map.get(sChar);
                    if (count == 0) {
                        charTLeft++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansIndex, ansIndex + ansLen);
    }
}

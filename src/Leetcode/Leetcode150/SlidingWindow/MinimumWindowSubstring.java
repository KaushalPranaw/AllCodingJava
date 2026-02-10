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

        //map to store t occurences
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            map.put(tc, map.getOrDefault(tc, 0) + 1);
        }

        int ansIndex = 0;
        int ansLen = Integer.MAX_VALUE;
        int tleft = t.length();
        int start = 0, end = 0;

        while (end < s.length()) {
            char ec = s.charAt(end);
            if (map.containsKey(ec)) {
                int count = map.get(ec);
                if (count > 0) {
                    tleft--;
                }
                map.put(ec, count - 1);
            }
            end++;

            while (tleft == 0) {
                if (ansLen > end - start) {
                    ansLen = end - start;
                    ansIndex = start;
                }
                char sc = s.charAt(start);
                if (map.containsKey(sc)) {
                    int count = map.get(sc);
                    if (count == 0) {
                        tleft++;
                    }
                    map.put(sc, count + 1);
                }
                start++;
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansIndex, ansLen + ansIndex);
    }
}

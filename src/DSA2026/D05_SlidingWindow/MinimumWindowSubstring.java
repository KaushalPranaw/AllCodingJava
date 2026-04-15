package DSA2026.D05_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        //Input: s = "ADOBECODEBANC", t = "ABC"
        //Output: "BANC"
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }

        //put t occurence in map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0, end = 0;
        int ansIndex = 0, ansLen = Integer.MAX_VALUE;
        int tleft = t.length();

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
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansIndex, ansIndex + ansLen);
    }
}

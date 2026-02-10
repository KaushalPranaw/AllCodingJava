package Leetcode.Leetcode150.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));

    }

    public int lengthOfLongestSubstring(String s) {
        //map to store <char, index> for right index
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            //duplicate found, move left to after where duplicate exist in map
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            //if first time, then inserting, and in case of duplicate updating index
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /*public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, max = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            while (set.contains(ch)) {
                set.remove(s.charAt(l++));
            }

            set.add(ch);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }*/
}

package Leetcode.Leetcode150.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));

    }

    public int lengthOfLongestSubstring(String s) {
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
    }
}

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
        int maxLen = 0;
        //map<char, latestIndex>
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                // Duplicate character mila hai.
                // Hum dekhte hain ki current character (s.charAt(right))
                // last time kis index par aaya tha.
                //
                // left ko uske next position par move karenge,
                // lekin left ko kabhi peeche nahi le jana hai.
                // Isliye Math.max use karte hain.
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
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

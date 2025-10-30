package Leetcode.Leetcode150.Array_String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int idx = 0;
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}

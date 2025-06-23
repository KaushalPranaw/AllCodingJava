package Leetcode.HashMap;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }

    //Approach 2
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            counter[c - 'a']--;
            if (counter[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }

    /*//Approach 1
    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = s.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return Arrays.equals(sa, ta);
    }*/
}

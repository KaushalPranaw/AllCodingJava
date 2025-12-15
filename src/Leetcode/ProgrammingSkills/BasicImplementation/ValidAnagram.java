package Leetcode.ProgrammingSkills.BasicImplementation;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        int[] ca = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ca[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ca[c - 'a']--;
            if (ca[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}

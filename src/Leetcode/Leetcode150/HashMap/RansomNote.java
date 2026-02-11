package Leetcode.Leetcode150.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

    }

    //ransomNote = "aa", magazine = "aab" - true
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return true;
        }

        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            letters[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = magazine.charAt(i);
            if (letters[c - 'a'] == 0) {
                return false;
            }
            letters[c - 'a']--;
        }
        return true;
    }
}

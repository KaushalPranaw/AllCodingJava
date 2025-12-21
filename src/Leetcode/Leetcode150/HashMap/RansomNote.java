package Leetcode.Leetcode150.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            letters[ch - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (letters[ch - 'a'] == 0) {
                return false;
            }
            letters[ch - 'a']--;
        }
        return true;
    }
}

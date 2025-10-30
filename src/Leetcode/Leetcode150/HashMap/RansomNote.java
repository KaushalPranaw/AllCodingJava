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

        int[] ca = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            ca[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (ca[ch - 'a'] == 0) {
                return false;
            }
            ca[ch - 'a']--;
        }
        return true;
    }
}

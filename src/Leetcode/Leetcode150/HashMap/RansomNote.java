package Leetcode.Leetcode150.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

    }

    //ransomNote = "aa", magazine = "aab" - true
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] countArray = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            countArray[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (countArray[c - 'a'] == 0) {
                return false;
            }
            countArray[c - 'a']--;
        }
        return true;

    }
}

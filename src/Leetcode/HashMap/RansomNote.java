package Leetcode.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] counter = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            counter[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (counter[c - 'a'] == 0) {
                return false;
            }
            counter[c - 'a']--;
        }
        return true;
    }
}

package DSA2026.D07_HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        //Input: s = "anagram", t = "nagaram"
        //
        //Output: true
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            letters[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            letters[ch - 'a']--;
            if (letters[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

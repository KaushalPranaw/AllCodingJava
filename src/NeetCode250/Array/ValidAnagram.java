package NeetCode250.Array;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ca = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ca[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = s.charAt(i);
            ca[c - 'a']--;
            if (ca[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}

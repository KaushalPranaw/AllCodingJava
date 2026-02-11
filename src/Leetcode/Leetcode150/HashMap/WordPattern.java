package Leetcode.Leetcode150.HashMap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(new WordPattern().wordPattern(pattern, s));
    }

    // pattern = "abba", str = "dog cat cat dog"
    public boolean wordPattern(String pattern, String str) {
        String[] sa = str.split(" ");
        if (sa.length != pattern.length()) {
            return false;
        }

        Map<String, Character> stringCharacterMap = new HashMap<>();
        Map<Character, String> characterStringMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = sa[i];
            if (stringCharacterMap.containsKey(s)) {
                if (stringCharacterMap.get(s) != c) {
                    return false;
                }
            } else {
                stringCharacterMap.put(s, c);
            }

            if (characterStringMap.containsKey(c)) {
                if (!characterStringMap.get(c).equals(s)) {
                    return false;
                }
            } else {
                characterStringMap.put(c, s);
            }
        }
        return true;
    }
}

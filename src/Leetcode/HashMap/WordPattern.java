package Leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(new WordPattern().wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<String, Character> wordToCharMap = new HashMap<>();
        Map<Character, String> charToWordMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (charToWordMap.containsKey(ch)) {
                if (!charToWordMap.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWordMap.put(ch, word);
            }

            if (wordToCharMap.containsKey(word)) {
                if (wordToCharMap.get(word) != ch) {
                    return false;
                }
            } else {
                wordToCharMap.put(word, ch);
            }
        }
        return true;

    }
}

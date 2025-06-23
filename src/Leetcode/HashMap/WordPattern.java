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
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charWordMap = new HashMap<>();
        Map<String, Character> wordCharMap = new HashMap<>();


        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (charWordMap.containsKey(c)) {
                if (!charWordMap.get(c).equals(word)) {
                    return false;
                }
            } else {
                charWordMap.put(c, word);
            }

            if (wordCharMap.containsKey(word)) {
                if (wordCharMap.get(word) != c) {
                    return false;
                }
            } else {
                wordCharMap.put(word, c);
            }

        }
        return true;

    }
}

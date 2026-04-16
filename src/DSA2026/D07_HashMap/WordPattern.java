package DSA2026.D07_HashMap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        //Input: pattern = "abba", s = "dog cat cat dog"
        //Output: true
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char ch = pattern.charAt(i);
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

package Comp.GSGR_PMW3;

import java.util.*;

public class Problem9_LongestWord {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});

        System.out.println(longestWord("toe", dict)); // Output: [toe]

        System.out.println(longestWord("oetdg", dict)); // Output: [dog, doe, god, toe]
    }

    private static Set<String> longestWord(String letters, Dictionary dict) {
        Map<Character, Integer> letterMap = getFreqMap(letters);

        Set<String> set = new HashSet<>();
        int maxLen = 0;

        for (String word : dict.getWords()) {
            Map<Character, Integer> wordMap = getFreqMap(word);
            if (canBeFormed(letterMap, wordMap)) {
                if (word.length() > maxLen) {
                    maxLen = word.length();
                    set.clear();
                    set.add(word);
                } else {
                    if (word.length() == maxLen) {
                        set.add(word);
                    }
                }
            }
        }
        return set;
    }

    private static boolean canBeFormed(Map<Character, Integer> letterMap, Map<Character, Integer> wordMap) {
        for (var entry : wordMap.entrySet()) {
            if (!letterMap.containsKey(entry.getKey())) {
                return false;
            } else {
                if (entry.getValue() > letterMap.get(entry.getKey())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    /*private static Set<String> longestWord(String letters, Dictionary dict) {
        // Convert the letters string into a frequency map
        Map<Character, Integer> letterMap = getFreqMap(letters);

        // Initialize variables to store the longest words
        Set<String> set = new HashSet<>();
        int maxLen = 0;

        // Iterate over each word in the dictionary
        for (String word : dict.getWords()) {
            // Convert the current word into a frequency map
            Map<Character, Integer> wordMap = getFreqMap(word);

            // Check if the word can be formed using the letters
            if (canBeFormed(letterMap, wordMap)) {
                // Update the result set with the longest word(s)
                if (word.length() > maxLen) {
                    set.clear();
                    set.add(word);
                    maxLen = word.length();
                } else {
                    if (word.length() == maxLen) {
                        set.add(word);
                    }
                }
            }
        }
        return set;
    }

    private static boolean canBeFormed(Map<Character, Integer> letterMap, Map<Character, Integer> wordMap) {
        for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (letterMap.getOrDefault(c, 0) < count) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }*/

}

// Simulating the given Dictionary class
class Dictionary {
    private Set<String> words;

    public Dictionary(String[] words) {
        this.words = new HashSet<>(Arrays.asList(words));
    }

    public Set<String> getWords() {
        return words;
    }
}

package Comp.GSGR_PMW3;

import java.util.HashSet;
import java.util.Set;

public class Problem15_Pangram {
    public static void main(String[] args) {
        System.out.println(findMissingLetters("The slow purple oryx meanders past the quiescent canine")); // bfgjkvz
        System.out.println(findMissingLetters("The quick brown fox jumps over the lazy dog")); // (empty)
        System.out.println(findMissingLetters("1234567890 !@#$$%^&*()")); // abcdefghijklmnopqrstuvwxyz
    }

    /*private static String findMissingLetters(String sentence) {
        Set<Character> found = new HashSet<>();

        // Convert sentence to lowercase and scan characters
        for (char ch : sentence.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                found.add(ch);
            }
        }

        StringBuilder missing = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!found.contains(ch)) {
                missing.append(ch);
            }
        }

        return missing.toString();


    }*/
    private static String findMissingLetters(String sentence) {
        Set<Character> set = new HashSet<>();
        StringBuilder missing = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                set.add(ch);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (!set.contains(c)) {
                missing.append(c);
            }
        }
        return missing.toString();
    }
}

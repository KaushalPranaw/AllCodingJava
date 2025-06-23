package Leetcode.Auto.Premium;

import java.util.HashMap;

public class CountPrefixAndSuffixPairsII {
    public static void main(String[] args) {
        String[] words = {"a","aba","ababa","aa"};
        System.out.println(new CountPrefixAndSuffixPairsII().countPrefixSuffixPairs(words));
    }

    /*public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }*/

    //rolling hashes
    private static final int BASE = 131; // Base for rolling hash
    private static final long MOD = (long) 1e18 + 3; // Modulo to avoid overflow
    public int countPrefixSuffixPairs(String[] words) {
        HashMap<Long, Integer> prefixSuffixMap = new HashMap<>();
        int count = 0;
        for (String word : words) {
            long prefixHash = 0, suffixHash = 0;
            int n = word.length();
            long power = 1;

            // Compute prefix and suffix hashes
            for(int i=0;i<n;i++){
                prefixHash = (prefixHash * BASE + word.charAt(i)) % MOD;
                suffixHash = (suffixHash + word.charAt(n - 1 - i) * power) % MOD;
                power = (power * BASE) % MOD;

                // If prefixHash == suffixHash, it means the substring [0..i] is both a prefix and a suffix
                if (prefixHash == suffixHash) {
                    // Add the frequency of this prefix-suffix combination to the count
                    count += prefixSuffixMap.getOrDefault(prefixHash, 0);
                }
            }
            // Update the prefix-suffix map with the current word's full hash
            long fullHash = prefixHash; // Full hash of the word
            prefixSuffixMap.put(fullHash, prefixSuffixMap.getOrDefault(fullHash, 0) + 1);
        }
        return count;
    }
}

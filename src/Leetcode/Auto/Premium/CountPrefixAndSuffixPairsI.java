package Leetcode.Auto.Premium;

public class CountPrefixAndSuffixPairsI {
    public static void main(String[] args) {
        String[] words = {"a","aba","ababa","aa"};
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(words));
    }

    public int countPrefixSuffixPairs(String[] words) {
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
    }
}

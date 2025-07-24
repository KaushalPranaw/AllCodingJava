package Comp.Addverb;

public class MinInsertionsPalindrome {
    public static void main(String[] args) {
        String input = "abcda";
        int result = minInsertions(input);
        System.out.println("Minimum insertions to make palindrome: " + result);
    }

    public static int minInsertions(String str) {
        int n = str.length();
        String rev = new StringBuilder(str).reverse().toString();
        return n - longestCommonSubsequence(str, rev);
    }

    // LCS of original and reversed string = Longest Palindromic Subsequence
    private static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}

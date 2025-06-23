package Leetcode.DP.DP03_Strings;

public class DP29_MinInsertionsToMakeStringPalindrome {
    public static void main(String args[]) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make the string palindrome: " + minInsertion(s));
    }

    private static int minInsertion(String s) {
        int n = s.length();
        int k = longestPalindromicSubstring(s);
        return n - k;
    }

    private static int longestPalindromicSubstring(String s) {
        return lcs(s, new StringBuilder(s).reverse().toString());
    }

    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

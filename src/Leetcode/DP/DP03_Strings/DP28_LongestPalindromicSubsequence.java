package Leetcode.DP.DP03_Strings;

public class DP28_LongestPalindromicSubsequence {
    public static void main(String args[]) {
        //Rule
        //The longest palindromic subsequence of a string is
        // the longest common subsequence of the given string and its reverse.
        String s = "bbabcbcab";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }

    private static String longestPalindromeSubsequence(String s) {
        return lcs(s, new StringBuilder(s).reverse().toString());
    }

    private static String lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int len = dp[m][n];
        char ca[] = new char[len];
        int index = len - 1;
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ca[index] = s1.charAt(i-1);
                i--;
                j--;
                index--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return new String(ca);
    }
}

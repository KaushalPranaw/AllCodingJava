package Leetcode.DP.DP03_Strings;

//https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/
public class DP31_ShortestCommonSupersequence {
    public static void main(String args[]) {

        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Longest Common Supersequence is " + shortestSupersequence(s1, s2));
    }

    private static String shortestSupersequence(String s1, String s2) {
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

        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    sb.append(s1.charAt(i - 1));
                    i--;
                } else {
                    sb.append(s2.charAt(j - 1));
                    j--;
                }
            }
        }
        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }
}

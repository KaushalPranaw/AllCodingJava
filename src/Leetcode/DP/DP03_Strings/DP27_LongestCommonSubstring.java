package Leetcode.DP.DP03_Strings;

public class DP27_LongestCommonSubstring {
    public static void main(String args[]) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Substring is " + lcsubString(s1, s2));
    }

    //tab
    /*private static int lcsubString(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }*/

    //space
    private static int lcsubString(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] prev = new int[n + 1];

//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j <= n; j++) {
//            dp[0][j] = 0;
//        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, cur[j]);
                } else {
                    cur[j] = 0;
                }
            }
            prev = cur.clone();
        }
        return ans;
    }
}

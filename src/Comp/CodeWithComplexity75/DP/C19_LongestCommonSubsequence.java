package Comp.CodeWithComplexity75.DP;

import java.util.Arrays;

public class C19_LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(new C19_LongestCommonSubsequence().longestCommonSubsequence(text1, text2));

    }

    /*//recur+memo
    public int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return longestCommonSubsequenceHelper(m - 1, n - 1, str1, str2, dp);

    }

    private int longestCommonSubsequenceHelper(int ind1, int ind2, String str1, String str2, int[][] dp) {
        //base case
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + longestCommonSubsequenceHelper(ind1 - 1, ind2 - 1, str1, str2, dp);
        } else {
            return dp[ind1][ind2] = Math.max(longestCommonSubsequenceHelper(ind1, ind2 - 1, str1, str2, dp),
                    longestCommonSubsequenceHelper(ind1 - 1, ind2, str1, str2, dp));
        }

    }*/

    /*//tab
    public int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];//since we have shifted one

        //for first row - dp[0][ind2]
        for (int ind2 = 0; ind2 <= n; ind2++) {
            dp[0][ind2] = 0;
        }
        //for first col - dp[ind1][0]
        for (int ind1 = 0; ind1 <= m; ind1++) {
            dp[ind1][0] = 0;
        }
        for (int ind1 = 1; ind1 <= m; ind1++) {
            for (int ind2 = 1; ind2 <= n; ind2++) {
                //match case
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    //not match case
                    dp[ind1][ind2] = Math.max(dp[ind1][ind2 - 1], dp[ind1 - 1][ind2]);
                }
            }
        }
        return dp[m][n];

    }*/

    //space
    public int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[] prev = new int[n + 1];//since we have shifted one

        for (int ind1 = 1; ind1 <= m; ind1++) {
            int[] cur = new int[n + 1];
            for (int ind2 = 1; ind2 <= n; ind2++) {
                //match case
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
                    cur[ind2] = 1 + prev[ind2 - 1];
                } else {
                    //not match case
                    cur[ind2] = Math.max(cur[ind2 - 1], prev[ind2]);
                }
            }
            prev = cur.clone();
        }
        return prev[n];

    }
}

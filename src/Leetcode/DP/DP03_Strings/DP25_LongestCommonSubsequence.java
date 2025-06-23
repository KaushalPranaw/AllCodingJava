package Leetcode.DP.DP03_Strings;

import java.util.Arrays;

public class DP25_LongestCommonSubsequence {
    public static void main(String args[]) {
        //for abc -> '', a, b, c, ,ab, bc, ac, abc
        //for len of n total subsequence will be 2(n) mean 2 ki power n
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
    }

    //recur+memo
    /*private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return lcsHelper(m - 1, n - 1, s1, s2, dp);
    }

    private static int lcsHelper(int ind1, int ind2, String s1, String s2, int[][] dp) {
        //base case
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        //match case
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcsHelper(ind1 - 1, ind2 - 1, s1, s2, dp);
        } else {
            //case : not match

            return dp[ind1][ind2] = Math.max(lcsHelper(ind1 - 1, ind2, s1, s2, dp),
                    lcsHelper(ind1, ind2 - 1, s1, s2, dp));
        }
    }*/

    //tabulation
    /*private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        //base case
        //if (ind1 < 0 || ind2 < 0) {
        //    return 0;
        //}

        //but in tabulation we can't have negative indexes
        //so we need to do shifting here
        //n-1=> n and m-1 => m
        //so -1=>0

        // so base case is
        //if (ind1 == 0 || ind2 == 0) {
        //    return 0;
        //}

        //so in dp
        //dp[0][ind2] || dp[ind1][0]
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
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    //case : not match
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2],
                            dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[m][n];
    }*/

    //space optimize
    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        //base case
        //if (ind1 < 0 || ind2 < 0) {
        //    return 0;
        //}

        //but in tabulation we can't have negative indexes
        //so we need to do shifting here
        //n-1=> n and m-1 => m
        //so -1=>0

        // so base case is
        //if (ind1 == 0 || ind2 == 0) {
        //    return 0;
        //}

        //so in dp
        //dp[0][ind2] || dp[ind1][0]
        int[] prev = new int[n + 1];//since we have shifted one
        int[] cur = new int[n + 1];

        //for first row - dp[0][ind2]
//        for (int ind2 = 0; ind2 <= n; ind2++) {
//            dp[0][ind2] = 0;
//        }
        //for first col - dp[ind1][0]
//        for (int ind1 = 0; ind1 <= m; ind1++) {
//            dp[ind1][0] = 0;
//        }

        for (int ind1 = 1; ind1 <= m; ind1++) {
            for (int ind2 = 1; ind2 <= n; ind2++) {
                //match case
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    cur[ind2] = 1 + prev[ind2 - 1];
                } else {
                    //case : not match
                    cur[ind2] = Math.max(prev[ind2],
                            cur[ind2 - 1]);
                }
            }
            prev = cur.clone();
        }
        return prev[n];
    }

}

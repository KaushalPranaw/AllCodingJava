package Leetcode.DP.DP03_Strings;

import java.util.Arrays;

public class DP34_WildcardMatching {
    public static void main(String args[]) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (wildcardMatching(S1, S2) == true)
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }

    /*//recur+memo
    private static boolean wildcardMatching(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Boolean[][] dp = new Boolean[m][n]; // Using wrapper class Boolean
        return wildcardMatchingUtil(m - 1, n - 1, s1, s2, dp);
    }

    private static boolean wildcardMatchingUtil(int i, int j, String s1, String s2, Boolean[][] dp) {
        //base case
        if (i < 0 && j < 0) {
            return true; // Both strings are empty, and the pattern matches.
        }
        if (i < 0 && j >= 0) {
            return false;// S1 is empty, but there are characters left in S2.
        }
        if (j < 0 && i >= 0) {
            //mtlb s2 k chars sare ho gye hai
            //s1 ke dekhege ki sare * hai ya ni
            //if sare remaining * hai to return true else return false
            return isAllStars(s1, i);// S2 is empty, check if remaining characters in S1 are all '*'.
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            //match case
            return dp[i][j] = wildcardMatchingUtil(i - 1, j - 1, s1, s2, dp);
        } else {
            // Two possibilities when encountering '*':
            // 1. '*' matches one or more characters in S2.
            // 2. '*' matches zero characters in S2.
            if (s1.charAt(i) == '*') {
                // CASE 1: remove
                //case 2:
                return dp[i][j] = wildcardMatchingUtil(i - 1, j, s1, s2, dp)
                        || wildcardMatchingUtil(i, j - 1, s1, s2, dp);
            } else {
                return dp[i][j] = false;
            }
        }

    }*/

    /*//tabulation
    private static boolean wildcardMatching(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1]; // Using wrapper class Boolean

        //base case
        *//*if (i == 0 && j == 0) {
            return true; // Both strings are empty, and the pattern matches.
        }
        if (i == 0 && j >= 0) {
            return false;// S1 is empty, but there are characters left in S2.
        }
        if (j == 0 && i >= 0) {
            return isAllStars(s1, i);// S2 is empty, check if remaining characters in S1 are all '*'.
        }*//*
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = isAllStars(s1, i);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Two possibilities when encountering '*':
                    // 1. '*' matches one or more characters in S2.
                    // 2. '*' matches zero characters in S2.
                    if (s1.charAt(i-1) == '*') {
                        dp[i][j] = dp[i - 1][j]
                                || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }


        return dp[m][n];
    }*/

    //space
    private static boolean wildcardMatching(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Boolean[] prev = new Boolean[n + 1]; // Using wrapper class Boolean

        //base case
        prev[0] = true;

        for (int i = 1; i <= m; i++) {
            Boolean[] cur = new Boolean[n + 1];
            cur[0] = isAllStars(s1, i);
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?') {
                    cur[j] = prev[j - 1];
                } else {
                    // Two possibilities when encountering '*':
                    // 1. '*' matches one or more characters in S2.
                    // 2. '*' matches zero characters in S2.
                    if (s1.charAt(i-1) == '*') {
                        cur[j] = prev[j]
                                || cur[j - 1];
                    } else {
                        cur[j] = false;
                    }
                }
            }
            prev=cur;
        }


        return prev[n];
    }

    // Helper function to check if all characters from index 0 to i in S1 are '*'
    static boolean isAllStars(String s1, int i) {
        for (int j = 0; j <= i; j++) {
            if (s1.charAt(j) != '*')
                return false;
        }
        return true;
    }
}

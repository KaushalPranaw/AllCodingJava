package Leetcode.DP.DP03_Strings;

import java.util.Arrays;

public class DP32_DistinctSubsequences {
    public static void main(String args[]) {
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting(s1, s2, s1.length(), s2.length()));
    }

    static int prime = (int) (Math.pow(10, 9) + 7);

    //recur+Memo
    /*private static int subsequenceCounting(String s1, String s2, int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return countUtil(m - 1, n - 1, s1, s2, dp);
    }

    private static int countUtil(int ind1, int ind2, String s1, String s2, int[][] dp) {

        //base case
        //if ind1<0 means we did not get result to result 0
        //if ind2<0 mtlb humne s2 ke sare chracter match kr liye hai to return 1
        if (ind2 < 0) {
            return 1;
        }
        if (ind1 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            //mtlb character same hai
            //case 1: dono string se hata do char aur check kro baki char
            //case 2: s2 se na hatao, kyuki aur b solution ho skte hai, since hume distinct sare chahiye
            int leaveOne = countUtil(ind1 - 1, ind2 - 1, s1, s2, dp);
            int stay = countUtil(ind1 - 1, ind2, s1, s2, dp);
            // Add the two possibilities and take modulo prime to avoid integer overflow.
            return dp[ind1][ind2] = (leaveOne + stay) % prime;

        } else {
            //agar same ni hai to s1 ka index reduce krege
            return dp[ind1][ind2] = countUtil(ind1 - 1, ind2, s1, s2, dp);
        }
    }*/

    //tabulation
    /*private static int subsequenceCounting(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
//        if (ind2 < 0) {
//            return 1;
//        }
//        // If we have exhausted s1 but not s2, there are no valid subsequences.
//        if (ind1 < 0) {
//            return 0;
//        }
        //ind2==0 then return 1;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        //since for j=0 it is 1 so start from 1
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }*/

    //space
    /*private static int subsequenceCounting(String s1, String s2, int m, int n) {
        int[] prev = new int[n + 1];
        //ind2==0 then return 1;
        prev[0] = 1;


        //since for j=0 it is 1 so start from 1
        for (int j = 1; j <= n; j++) {
            prev[j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            cur[0] = 1;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = (prev[j - 1] + prev[j]) % prime;
                } else {
                    cur[j] = prev[j];
                }
            }
            prev = cur.clone();
        }
        return prev[n];
    }*/

    //more optimize
    private static int subsequenceCounting(String s1, String s2, int m, int n) {
        int[] prev = new int[n + 1];
        //ind2==0 then return 1;
        prev[0] = 1;


        //since for j=0 it is 1 so start from 1
        for (int j = 1; j <= n; j++) {
            prev[j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    prev[j] = (prev[j - 1] + prev[j]) % prime;
                } else {
                    prev[j] = prev[j];
                }
            }
        }
        return prev[n];
        /*int[] prev = new int[n + 1];

        prev[0] = 1;

        for (int ind1 = 1; ind1 <= m; ind1++) {
            for (int ind2 = n; ind2 >= 1; ind2--) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    int leaveOne = prev[ind2 - 1];
                    int stay = prev[ind2];
                    // Add the two possibilities and take modulo prime to avoid integer overflow.
                    prev[ind2] = (leaveOne + stay) % prime;

                } else {
                    // If the characters don't match, we can only continue to the next character in s1.
                    prev[ind2] = prev[ind2];// This statement is not necessary
                }
            }
        }
        return prev[n];*/
    }

}

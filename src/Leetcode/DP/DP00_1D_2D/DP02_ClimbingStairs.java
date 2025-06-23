package Leetcode.DP.DP00_1D_2D;

import java.util.Arrays;

public class DP02_ClimbingStairs {
    //Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair. At a time we can climb either one or two steps. We need to return the total number of distinct ways to reach from 0th to Nth stair.
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new DP02_ClimbingStairs().climbStairs(n));
    }

    //recur+memo
    /*public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsHelper(n - 1, dp);

    }

    private int climbStairsHelper(int ind, int[] dp) {
        //base case
        if (ind == 0) return 1;
        if (ind == 1) return 1;
        if (dp[ind] != -1) return dp[ind];

        return dp[ind] = climbStairsHelper(ind - 1, dp) + climbStairsHelper(ind - 2, dp);
    }*/

    //bottom up
    /*public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int ind = 2; ind <= n; ind++) {
            dp[ind] = dp[ind - 1] + dp[ind - 2];
        }
        return dp[n];
    }*/

    //space optimize
    public int climbStairs(int n) {

        int prev2 = 1;
        int prev = 1;
        for (int ind = 2; ind <= n; ind++) {
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}

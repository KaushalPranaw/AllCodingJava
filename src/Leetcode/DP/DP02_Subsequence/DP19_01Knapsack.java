package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;
import java.util.Map;

//https://takeuforward.org/data-structure/0-1-knapsack-dp-19
public class DP19_01Knapsack {
    public static void main(String[] args) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        // Calculate and print the maximum value of items the thief can steal
        System.out.println("The Maximum value of items the thief can steal is " + knapsack(wt, val, n, W));
    }

    //recur+memo
    /*private static int knapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return knapsackUtil(n - 1, W, wt, val, dp);

    }

    private static int knapsackUtil(int ind, int W, int[] wt, int[] val, int[][] dp) {
        //base case
        if (ind == 0) {
            if (wt[ind] <= W) {
                return val[ind];
            } else {
                return 0;
            }
        }
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int not_take = 0 + knapsackUtil(ind - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (W - wt[ind] >= 0) {
            take = val[ind] + knapsackUtil(ind - 1, W - wt[ind], wt, val, dp);
        }
        return dp[ind][W] = Math.max(take, not_take);
    }*/

    //tabulation
    /*private static int knapsack(int[] wt, int[] val, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        //base case
        //What’s the max value we can get using items 0 to ind, with capacity W?
        *//*for (int i = wt[0]; i <= maxWeight; i++) {
            dp[0][i] = val[0];
        }*//*
        //for first row
        for (int w = 0; w <= maxWeight; w++) {
            if (wt[0] <= w) {
                dp[0][w] = val[0];
            } else {
                dp[0][w] = 0;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= maxWeight; W++) {
                int not_take = 0 + dp[ind - 1][W];
                int take = Integer.MIN_VALUE;
                if (W - wt[ind] >= 0) {
                    take = val[ind] + dp[ind - 1][W - wt[ind]];
                }
                dp[ind][W] = Math.max(take, not_take);
            }
        }
        return dp[n - 1][maxWeight];
    }*/

    //space optimization
    /*private static int knapsack(int[] wt, int[] val, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];
        //base case
        for (int w = 0; w <= maxWeight; w++) {
            if (wt[0] <= w) {
                prev[w] = val[0];
            } else {
                prev[w] = 0;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[maxWeight + 1];
            for (int W = 0; W <= maxWeight; W++) {
                int not_take = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (W - wt[ind] >= 0) {
                    take = val[ind] + prev[W - wt[ind]];
                }
                cur[W] = Math.max(take, not_take);
            }
            prev=cur.clone();
        }
        return prev[maxWeight];
    }*/

    //space optimization - again optimize from 2 rows to one row
    private static int knapsack(int[] wt, int[] val, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];
        //base case where ind=0
        for (int w = 0; w <= maxWeight; w++) {
            if (wt[0] <= w) {
                prev[w] = val[0];
            } else {
                prev[w] = 0;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            //int[] cur = new int[maxWeight + 1]; not required
            //for (int W = 0; W <= maxWeight; W++) {
            for (int W = maxWeight; W >= 0; W--) {//since weight is reducing from W to 0
                //copy paste recurrence
                int notTaken = 0 + prev[W];
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    taken = val[ind] + prev[W - wt[ind]];
                }
                //cur[W] = Math.max(taken, notTaken);
                prev[W] = Math.max(taken, notTaken);
            }
            //prev = cur; // not required
        }
        return prev[maxWeight];
    }
}

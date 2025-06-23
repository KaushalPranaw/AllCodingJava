package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

public class DP23_UnboundedKnapsack {
    public static void main(String args[]) {
        int wt[] = {2, 4, 6};
        int val[] = {5, 11, 13};
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));
    }

    //recur+memo
    /*private static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n][W + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return unboundedKnapsackUtil(n - 1, W, val, wt, dp);
    }

    private static int unboundedKnapsackUtil(int ind, int W, int[] val, int[] wt, int[][] dp) {
        //base case
        if (ind == 0) {
            return (W / wt[0]) * val[0];//just to get max output instead of completely full
        }

        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTaken = unboundedKnapsackUtil(ind - 1, W, val, wt, dp);
        int taken = 0;
        if (W-wt[ind] >=0) {
            taken = val[ind] + unboundedKnapsackUtil(ind, W - wt[ind], val, wt, dp);
        }
        return dp[ind][W] = Math.max(notTaken, taken);
    }*/

    //tabulation
    /*private static int unboundedKnapsack(int n, int totalWeight, int[] val, int[] wt) {
        int[][] dp = new int[n][totalWeight + 1];
        //base case
        *//*for (int w = 0; w <= maxWeight; w++) {
            if (wt[0] <= w) {
                dp[0][w] = val[0];
            } else {
                dp[0][w] = 0;
            }
        }*//*

        for(int W=0;W<=totalWeight;W++){
            if(wt[0]<=W){
                dp[0][W] = (W / wt[0]) * val[0];
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= totalWeight; W++) {
                int notTaken = dp[ind - 1][W];
                int taken = 0;
                if (wt[ind] <= W) {
                    taken = val[ind] + dp[ind][W - wt[ind]];
                }
                dp[ind][W] = Math.max(notTaken, taken);
            }
        }

        return dp[n - 1][totalWeight];
    }*/

    //space
    private static int unboundedKnapsack(int n, int totalWeight, int[] val, int[] wt) {
        int[] cur = new int[totalWeight + 1];
        //base case

        for(int W=0;W<=totalWeight;W++){
            if(wt[0]<=W){
                cur[W] = (W / wt[0]) * val[0];
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= totalWeight; W++) {
                int notTaken = cur[W];
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    taken = val[ind] + cur[W - wt[ind]];
                }
                cur[W] = Math.max(notTaken, taken);
            }
        }


        return cur[totalWeight];
    }
}

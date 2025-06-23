package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

public class DP24_RodCuttingProblem {
    public static void main(String[] args) {
        int[] prices = {2, 5, 7, 8, 10};
        int N = 5;
        System.out.println(maxPrices(prices, N));
    }

    //recur+memo
    /*private static int maxPrices(int[] prices, int N) {
        int n = prices.length;
        int[][] dp = new int[n][N + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return maxPricesUtil(n - 1, N, prices, dp);
    }

    private static int maxPricesUtil(int ind, int N, int[] prices, int[][] dp) {
        //rod len=ind+1;

        //base case
        if (ind == 0) {
            //mean length is one
            //price of length one is price[0]
            //so we have N size
            //so it will be N*price[0]
            return N * prices[0];
        }

        if (dp[ind][N] != -1) {
            return dp[ind][N];
        }

        int notTaken = maxPricesUtil(ind - 1, N, prices, dp);
        int taken = Integer.MIN_VALUE;
        //for ind , rod length will be ind+1
        int rodLength = ind + 1;
        if (rodLength <= N) {
            taken = prices[ind] + maxPricesUtil(ind, N - rodLength, prices, dp);
        }

        return dp[ind][N] = Math.max(taken, notTaken);
    }*/

    //tabulation
    /*private static int maxPrices(int[] prices, int totalLength) {
        int n = prices.length;
        int[][] dp = new int[n][totalLength + 1];

        //base case

        for (int N = 0; N <= totalLength; N++) {
            dp[0][N] = N * prices[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int N = 0; N <= totalLength; N++) {
                int notTaken = dp[ind - 1][N];
                int taken = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= N) {
                    taken = prices[ind] + dp[ind][N - rodLength];
                }

                dp[ind][N] = Math.max(taken, notTaken);
            }
        }
        return dp[n - 1][totalLength];
    }*/

    //space
    private static int maxPrices(int[] prices, int totalLength) {
        int n = prices.length;
        int[] cur = new int[totalLength + 1];

        //base case

        for (int N = 0; N <= totalLength; N++) {
            cur[N] = N * prices[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int N = 0; N <= totalLength; N++) {
                int notTaken = cur[N];
                int taken = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= N) {
                    taken = prices[ind] + cur[N - rodLength];
                }

                cur[N] = Math.max(taken, notTaken);
            }
        }
        return cur[totalLength];
    }
}

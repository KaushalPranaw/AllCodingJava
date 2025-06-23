package Leetcode.DP.DP04_Stocks;

import java.util.Arrays;

public class DP40_BuyAndSellStocksWithTransactionFee {
    public static void main(String args[]) {
        int prices[] = {1, 3, 2, 8, 4, 9};
        int n = prices.length;
        int fee = 2;

        System.out.println("The maximum profit that can be generated is " + maximumProfitWithFee(n, fee, prices));
    }

    /*//recur+memo
    private static int maximumProfitWithFee(int n, int fee, int[] prices) {
        int dp[][] = new int[n][2];

        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        if (n == 0) {
            return 0;
        }
        return maximumProfitWithFeeHelper(0, 1, prices, fee, n, dp);
    }

    private static int maximumProfitWithFeeHelper(int ind, int buy, int[] prices, int fee, int n, int[][] dp) {
        //base case
        if (ind == n) {
            return 0;
        }

        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[ind] + maximumProfitWithFeeHelper(ind + 1, 0, prices, fee, n, dp),
                    0 + maximumProfitWithFeeHelper(ind + 1, 1, prices, fee, n, dp));
        } else {
            //sold case
            profit = Math.max(prices[ind] - fee + maximumProfitWithFeeHelper(ind + 1, 1, prices, fee, n, dp),
                    0 + maximumProfitWithFeeHelper(ind + 1, 0, prices, fee, n, dp));
        }
        return dp[ind][buy] = profit;
    }*/

    /*//tabulation
    private static int maximumProfitWithFee(int n, int fee, int[] prices) {
        int dp[][] = new int[n + 1][2];

        for (int ind = n - 1; ind >= 0; ind--) {
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);
            dp[ind][0] = Math.max(prices[ind] + dp[ind + 1][1] - fee, 0 + dp[ind + 1][0]);
        }
        return dp[0][1];
    }*/

    //space
    private static int maximumProfitWithFee(int n, int fee, int[] prices) {
        int front[] = new int[2];
        int cur[] = new int[2];

        for (int ind = n - 1; ind >= 0; ind--) {
            cur[1] = Math.max(-prices[ind] + front[0], 0 + front[1]);
            cur[0] = Math.max(prices[ind] + front[1] - fee, 0 + front[0]);

            front = cur;
        }
        return cur[1];
    }
}

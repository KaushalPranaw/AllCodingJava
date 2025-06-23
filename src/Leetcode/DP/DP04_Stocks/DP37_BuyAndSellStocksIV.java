package Leetcode.DP.DP04_Stocks;

import java.util.Arrays;

public class DP37_BuyAndSellStocksIV {
    public static void main(String[] args) {
        //We can do at most K transactions.
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + maxProfit(prices, k));
    }

    //recur+memo
    /*private static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        //buy->1
        //sell->1
        return maxProfitHelper(0, 1, k, prices, n, dp);
    }

    private static int maxProfitHelper(int ind, int buy, int cap, int[] prices, int n, int[][][] dp) {
        //base case
        if (ind == n) {
            return 0;
        }
        if (cap == 0) {
            return 0;
        }
        if (dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }
        //buy case
        if (buy == 1) {
            //skip
            int op1 = maxProfitHelper(ind + 1, 1, cap, prices, n, dp);
            //buy
            int op2 = -prices[ind] + maxProfitHelper(ind + 1, 0, cap, prices, n, dp);
            dp[ind][buy][cap] = Math.max(op1, op2);
        } else {
            //skip
            int op1 = maxProfitHelper(ind + 1, 0, cap, prices, n, dp);
            //sell
            int op2 = prices[ind] + maxProfitHelper(ind + 1, 1, cap-1, prices, n, dp);
            dp[ind][buy][cap] = Math.max(op1, op2);
        }
        return dp[ind][buy][cap];
    }*/

    //tabulation
    /*private static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        //base case
        //not needed since already having 0

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < k; cap++) {
                    //buy case
                    if (buy == 1) {
                        //skip
                        int op1 = dp[ind + 1][1][cap];
                        //buy
                        int op2 = -prices[ind] + dp[ind + 1][0][cap];
                        dp[ind][buy][cap] = Math.max(op1, op2);
                    } else {
                        //skip
                        int op1 = dp[ind + 1][0][cap];
                        //sell
                        int op2 = prices[ind] + dp[ind + 1][1][cap - 1];
                        dp[ind][buy][cap] = Math.max(op1, op2);
                    }
                }
            }
        }
        return dp[0][1][2];
    }*/

    //space
    private static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        int[][] ahead = new int[2][k+1];

        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] cur = new int[2][k+1];
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-prices[ind] + ahead[0][cap],
                                0 + ahead[1][cap]);
                    } else {
                        profit = Math.max(prices[ind] + ahead[1][cap - 1],
                                0 + ahead[0][cap]);
                    }
                    cur[buy][cap] = profit;
                }
            }
            // Update 'ahead' with the values in 'cur'
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= k; j++) {
                    ahead[i][j] = cur[i][j];
                }
            }
        }
        return ahead[1][2];
    }
}

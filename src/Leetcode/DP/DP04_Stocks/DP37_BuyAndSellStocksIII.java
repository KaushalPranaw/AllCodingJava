package Leetcode.DP.DP04_Stocks;

import java.util.Arrays;

public class DP37_BuyAndSellStocksIII {
    public static void main(String[] args) {
        //We can do at most 2 transactions.
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + maxProfit(prices));
    }

    //recur+memo
    /*private static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return maxProfitHelper(0, 0, 2, prices, n, dp);
    }

    private static int maxProfitHelper(int ind, int buy, int cap, int[] prices, int n, int[][][] dp) {
        //base case
        if (ind == n || cap == 0) {
            return 0;
        }

        if (dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }


        //buy case
        if (buy == 0) {
            //case 1: skip
            int op1 = maxProfitHelper(ind + 1, 0, cap, prices, n, dp);
            //case 2: buy
            int op2 = -prices[ind] + maxProfitHelper(ind + 1, 1, cap, prices, n, dp);
            dp[ind][buy][cap] = Math.max(op1, op2);
        } else {
            //case 1: skip
            int op1 = maxProfitHelper(ind + 1, 1, cap, prices, n, dp);
            //case 2: sell
            int op2 = prices[ind] + maxProfitHelper(ind + 1, 0, cap - 1, prices, n, dp);
            dp[ind][buy][cap] = Math.max(op1, op2);
        }
        return dp[ind][buy][cap];

    }*/

    //tabulation
    /*private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        //we can remove below base case since array is already 0

        //cap==0 => ind and buy can be anything
        *//*for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[ind][buy][0] = 0;
            }
        }*//*
        //ind==n => buy and cap can be anything
        *//*for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= 2; cap++) {
                dp[n][buy][cap] = 0;
            }
        }*//*

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    //buy case
                    if (buy == 0) {
                        //case 1: skip
                        int op1 = dp[ind + 1][0][cap];
                        //case 2: buy
                        int op2 = -prices[ind] + dp[ind + 1][1][cap];
                        dp[ind][buy][cap] = Math.max(op1, op2);
                    } else {
                        //case 1: skip
                        int op1 = dp[ind + 1][1][cap];
                        //case 2: sell
                        int op2 = prices[ind] + dp[ind + 1][0][cap - 1];
                        dp[ind][buy][cap] = Math.max(op1, op2);
                    }
                }
            }
        }
        return dp[0][0][2];
    }*/

    //space
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] cur=new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    //buy case
                    if (buy == 0) {
                        //case 1: skip
                        int op1 = ahead[0][cap];
                        //case 2: buy
                        int op2 = -prices[ind] + ahead[1][cap];
                        cur[buy][cap] = Math.max(op1, op2);
                    } else {
                        //case 1: skip
                        int op1 = ahead[1][cap];
                        //case 2: sell
                        int op2 = prices[ind] + ahead[0][cap - 1];
                        cur[buy][cap] = Math.max(op1, op2);
                    }
                }
            }
            //ahead=cur.clone();//will now work since it is giving shallow copy
            //for deep copy below code is needed
            // Update 'ahead' with the values in 'cur'
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 3; j++) {
                    ahead[i][j] = cur[i][j];
                }
            }
        }
        return ahead[0][2];
    }
}

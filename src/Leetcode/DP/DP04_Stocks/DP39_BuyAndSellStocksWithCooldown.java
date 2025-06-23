package Leetcode.DP.DP04_Stocks;

import java.util.Arrays;

public class DP39_BuyAndSellStocksWithCooldown {
    public static void main(String args[]) {
        int prices[] = {4, 9, 0, 4, 10};
        //cooldown means after selling next day will be cooldown
        //so after selling one day after you can buy
        //4->9 then 0 is cooldown then again you can buy at 4->10 like this

        System.out.println("The maximum profit that can be generated is " + stockProfit(prices));
    }

    //recur+memo
    /*private static int stockProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return stockProfitHelper(0, 1, prices, n, dp);
    }

    private static int stockProfitHelper(int ind, int buy, int[] prices, int n, int[][] dp) {
        //base case
        if (ind >= n) {
            return 0;
        }
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        //buy==1
        if (buy == 1) {
            //skip
            int op1 = stockProfitHelper(ind + 1, 1, prices, n, dp);
            //buy
            int op2 = -prices[ind] + stockProfitHelper(ind + 1, 0, prices, n, dp);
            dp[ind][buy] = Math.max(op1, op2);
        } else {
            //skip
            int op1 = stockProfitHelper(ind + 1, 0, prices, n, dp);
            //sell
            int op2 = prices[ind] + stockProfitHelper(ind + 2, 1, prices, n, dp);
            dp[ind][buy] = Math.max(op1, op2);
        }
        return dp[ind][buy];
    }*/

    //tabulation
    /*private static int stockProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                //buy==1
                if (buy == 1) {
                    //skip
                    int op1 = dp[ind + 1][1];
                    //buy
                    int op2 = -prices[ind] + dp[ind + 1][0];
                    dp[ind][buy] = Math.max(op1, op2);
                } else {
                    //skip
                    int op1 = dp[ind + 1][0];
                    //sell
                    int op2 = prices[ind] + dp[ind + 2][1];
                    dp[ind][buy] = Math.max(op1, op2);
                }
            }
        }
        return dp[0][1];

    }*/

    //space
    private static int stockProfit(int[] prices) {
        int n = prices.length;

        int[] front1 = new int[2];
        int[] front2 = new int[2];
        int[] cur = new int[2];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                //buy==1
                if (buy == 1) {
                    //skip
                    int op1 = front1[1];
                    //buy
                    int op2 = -prices[ind] + front1[0];
                    cur[buy] = Math.max(op1, op2);
                } else {
                    //skip
                    int op1 = front1[0];
                    //sell
                    int op2 = prices[ind] + front2[1];
                    cur[buy] = Math.max(op1, op2);
                }
            }
            front2 = front1.clone();
            front1 = cur.clone();
        }
        return front1[1];
    }
}

package Leetcode.DP.DP04_Stocks;

import java.util.Arrays;
import java.util.Map;

public class DP36_BuyAndSellStockII {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit(arr));
    }

    //recur+memo
    /*public static int getMaximumProfit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return getMaximumProfitHelper(0, 0, arr, n, dp);
    }

    private static int getMaximumProfitHelper(int ind, int buy, int[] arr, int n, int[][] dp) {
        //base case
        if (ind == n) {
            return 0;//we came out from arr
        }

        // if already computed
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        //means we have to buy since buy=0
        if (buy == 0) {
            //case 1: skip
            int op1 = getMaximumProfitHelper(ind + 1, buy, arr, n, dp);
            //case 2: buy
            //if we are buying then we can giving money since so -> -arr[i]
            int op2 = -arr[ind] + getMaximumProfitHelper(ind + 1, 1, arr, n, dp);
            dp[ind][buy] = Math.max(op1, op2);
        }
        //mean we have to sell since buy=1
        else {
            //case 1: skip
            int op1 = getMaximumProfitHelper(ind + 1, buy, arr, n, dp);
            //case 2: sell
            //since we are selling so will get some money so -> arr[i]
            int op2 = arr[ind] + getMaximumProfitHelper(ind + 1, 0, arr, n, dp);
            dp[ind][buy] = Math.max(op1, op2);
        }
        return dp[ind][buy];
    }*/

    //tabulation
    /*public static int getMaximumProfit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        //base case

        //if (ind == n) {
        //    return 0;//we came out from arr
        //}

        //so since we have 2 option so need not to create loop
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                //means we have to buy since buy=0
                if (buy == 0) {
                    //case 1: skip
                    int op1 = dp[ind + 1][0];
                    //case 2: buy
                    //if we are buying then we can giving money since so -> -arr[i]
                    int op2 = -arr[ind] + dp[ind + 1][1];
                    dp[ind][buy] = Math.max(op1, op2);
                }
                //mean we have to sell since buy=1
                else {
                    //case 1: skip
                    int op1 = dp[ind + 1][1];
                    //case 2: sell
                    //since we are selling so will get some money so -> arr[i]
                    int op2 = arr[ind] + dp[ind + 1][0];
                    dp[ind][buy] = Math.max(op1, op2);
                }
            }
        }
        return dp[0][0];


    }*/

    //space
    public static int getMaximumProfit(int[] arr) {
        int n = arr.length;
        int[] ahead = new int[2];
        //base case

        //so since we have 2 option so need not to create loop
        ahead[0] = 0;
        ahead[1] = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            int[] cur = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                //means we have to buy since buy=0
                if (buy == 0) {
                    //case 1: skip
                    int op1 = ahead[0];
                    //case 2: buy
                    //if we are buying then we can giving money since so -> -arr[i]
                    int op2 = -arr[ind] + ahead[1];
                    cur[buy] = Math.max(op1, op2);
                }
                //mean we have to sell since buy=1
                else {
                    //case 1: skip
                    int op1 = ahead[1];
                    //case 2: sell
                    //since we are selling so will get some money so -> arr[i]
                    int op2 = arr[ind] + ahead[0];
                    cur[buy] = Math.max(op1, op2);
                }
            }
            ahead=cur.clone();
        }
        return ahead[0];
    }
}

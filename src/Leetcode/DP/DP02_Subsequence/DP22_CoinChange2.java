package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

public class DP22_CoinChange2 {
    // We are given an array Arr with N distinct coins and a target.
    // We have an infinite supply of each coin denomination.
    // We need to find the number of ways we sum up the coin values to give us the target.
    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
    }

    //recur+memo
    /*private static int countWaysToMakeChange(int[] arr, int n, int target) {
        int[][] dp = new int[n][target + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return countWaysToMakeChangeUtil(n - 1, target, arr, dp);
    }

    private static int countWaysToMakeChangeUtil(int ind, int T, int[] arr, int[][] dp) {
        //base case
        if (ind == 0) {
            return T % arr[ind] == 0 ? 1 : 0;
        }

        if (dp[ind][T] != -1) {
            return dp[ind][T];
        }

        int notTake = countWaysToMakeChangeUtil(ind - 1, T, arr, dp);
        int take = 0;
        if (T - arr[ind] >= 0) {
            take = countWaysToMakeChangeUtil(ind, T - arr[ind], arr, dp);
        }

        return dp[ind][T] = take + notTake;

    }*/

    //tabulation
    /*private static int countWaysToMakeChange(int[] arr, int n, int target) {
        int[][] dp = new int[n][target + 1];
        //base case
        for (int T = 0; T <= target; T++) {
            if (T % arr[0] == 0) {
                dp[0][T] = 1;
            } else {
                dp[0][T] = 0;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int T = 0; T <= target; T++) {
                int notTake = dp[ind - 1][T];
                int take = 0;
                if (T - arr[ind] >= 0) {
                    take = dp[ind][T - arr[ind]];
                }
                dp[ind][T] = take + notTake;
            }
        }
        return dp[n - 1][target];
    }*/

    //space
    private static int countWaysToMakeChange(int[] arr, int n, int target) {
        int[] prev = new int[target + 1];
        //base case
       /* if (ind == 0) {
            return T % arr[0] == 0 ? 1 : 0;
        }*/
        for (int T = 0; T <= target; T++) {
            if (T % arr[0] == 0) {
                prev[T] = 1;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[target + 1];
            for (int T = 0; T <= target; T++) {
                int notTaken = prev[T];
                int taken = 0;
                if (arr[ind] <= T) {
                    taken = cur[T - arr[ind]];
                }
                cur[T] = taken + notTaken;
            }
            prev = cur;
        }
        return prev[target];
    }
}

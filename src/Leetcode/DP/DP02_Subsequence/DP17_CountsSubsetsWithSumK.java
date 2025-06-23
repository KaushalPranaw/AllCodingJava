package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

public class DP17_CountsSubsetsWithSumK {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWays(arr, k));
    }


    //recur+memo
    /*private static int findWays(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findWaysUtil(n - 1, k, arr, dp);
    }

    private static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
        // Base case
        if (target == 0) {
            return 1;
        }

        if (ind == 0) {
            if (arr[ind] == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int not_take = findWaysUtil(ind - 1, target, arr, dp);
        int take = findWaysUtil(ind - 1, target - arr[ind], arr, dp);
        return dp[ind][target] = not_take + take;

    }*/

    //tabulation
    /*private static int findWays(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first column of the DP array
        if (arr[0] <= k) {
            dp[0][arr[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
                int not_take = dp[ind - 1][target];
                int take = 0;
                if (target - arr[ind] >= 0) {
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = not_take + take;
            }
        }
        return dp[n-1][k];

    }*/


    //space
    private static int findWays(int[] arr, int k) {
        int n = arr.length;
        int[] prev = new int[k + 1];
        //base case
        for (int i = 0; i < n; i++) {
            prev[0] = 1;
        }
        if (arr[0] <= k)
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[k + 1];
            cur[0] = 1;
            for (int target = 1; target <= k; target++) {
                int notTaken = prev[target];
                int taken = 0;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }
                cur[target] = notTaken + taken;
            }
            prev = cur;
        }
        return prev[k];
    }
}

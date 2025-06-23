package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

//For example, for the array: [2,3,1] ,
// the subsequences will be [{2},{3},{1},{2,3},{2,1},{3,1},{2,3,1}}
// but {3,2} is not a subsequence because its elements are not in the same order as the original array.
public class DP14_SubsetSumEqualToTarget {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }

    //recur+memo
    /*private static boolean subsetSumToK(int n, int target, int[] arr) {
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return subsetSumToKHelper(n - 1, target, arr, dp);

    }

    private static boolean subsetSumToKHelper(int ind, int target, int[] arr, int[][] dp) {
        //base case
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[ind] == target;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target] == 0 ? false : true;
        }

        boolean not_take = subsetSumToKHelper(ind - 1, target, arr, dp);
        boolean take = false;
        if (target - arr[ind] >= 0) {
            take = subsetSumToKHelper(ind - 1, target - arr[ind], arr, dp);
        }
        dp[ind][target] = take || not_take ? 1 : 0;
        return take || not_take;

    }*/

    //tabulation
    /*private static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {//to handle overflow
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
                boolean not_take = dp[ind - 1][target];
                boolean take = false;
                if (target - arr[ind] >= 0) {
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = take || not_take;
            }
        }

        return dp[n - 1][k];
    }*/

    //space
    private static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];
        for (int i = 0; i < n; i++) {
            prev[0] = true;
        }

        if (arr[0] <= k) {//to handle overflow
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[k + 1];
            // Initialize the first column of the current row
            cur[0] = true;
            for (int target = 0; target <= k; target++) {
                boolean not_take = prev[target];
                boolean take = false;
                if (target - arr[ind] >= 0) {
                    take = prev[target - arr[ind]];
                }
                cur[target] = take || not_take;
            }
            prev = cur.clone();
        }

        return prev[k];
    }
}

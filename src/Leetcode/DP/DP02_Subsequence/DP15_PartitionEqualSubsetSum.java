package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;
import java.util.List;

//https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/
public class DP15_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;

        if (canPartition(n, arr))
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static boolean canPartition(int n, int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 == 0) {
            return subsetSumToK(n, sum / 2, arr);
        } else {
            return false;
        }
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
            return dp[ind][target] == 0;
        }

        boolean not_take = subsetSumToKHelper(ind - 1, target, arr, dp);
        boolean take = false;
        if (target - arr[ind] >= 0) {
            take = subsetSumToKHelper(ind, target - arr[ind], arr, dp);
        }
        dp[ind][target] = not_take || take ? 0 : -1;
        return not_take || take;
    }*/

    //tabulation
    private static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
                boolean not_take = dp[ind - 1][target];
                boolean take = false;
                if (target - arr[ind] >= 0) {
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = not_take || take;
            }
        }
        return dp[n - 1][k];
    }

    //space
    /*private static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];

        for (int i = 0; i < n; i++) {
            prev[0] = true;
        }

        if(arr[0]<=k)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[k + 1];
            for (int target = 1; target <= k; target++) {
                boolean not_take = prev[target];
                boolean take = false;
                if (arr[ind] <= target) {
                    take = prev[target - arr[ind]];
                }
                cur[target] = not_take || take;
            }
            prev = cur;
        }

        return prev[k];
    }*/
}

package Leetcode.DP.DP02_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP16_PartitionTwoSubsetsWithMinAbsoluteSumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
    }

    /*//tabulation
    private static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[n][totalSum + 1];

        //base case
        for (int target = 0; target <= totalSum; target++) {
            dp[0][target] = (target == arr[0]);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totalSum; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int target = 0; target <= totalSum; target++) {
            if (dp[n - 1][target] == true) {
                int s1 = target;
                int s2 = totalSum - target;
                int diff = Math.abs(s1 - s2);
                min = Math.min(min, diff);
            }
        }

        return min;

    }*/

    //space
    private static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = Arrays.stream(arr).sum();
        boolean[] prev = new boolean[totalSum + 1];

        //base case
        for (int target = 0; target <= totalSum; target++) {
            prev[target] = (target == arr[0]);
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] cur = new boolean[totalSum + 1];
            for (int target = 1; target <= totalSum; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }
                cur[target] = notTaken || taken;
            }
            prev=cur;
        }

        int min = Integer.MAX_VALUE;
        for (int target = 0; target <= totalSum; target++) {
            if (prev[target] == true) {
                int s1 = target;
                int s2 = totalSum - target;
                int diff = Math.abs(s1 - s2);
                min = Math.min(min, diff);
            }
        }

        return min;

    }
}

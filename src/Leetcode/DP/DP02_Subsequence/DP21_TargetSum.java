package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

public class DP21_TargetSum {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 1};
        int target = 3;
        //Apply + or  - sign and try to get target means how many ways we can get

        int n = arr.length;

        // Call the targetSum function and print the result
        System.out.println("The number of ways found is " + targetSum(n, target, arr));
    }

    private static int targetSum(int n, int target, int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        if (totalSum - target < 0) {
            return 0;
        }
        if ((totalSum - target) % 2 != 0) {//can't be partitioned
            return 0;
        }
        /*
        s1+s2=totalSum
        s1=totalSum-s2

        s1-s2=target
        totalSum-s2-s2=target
        s2=(totalSum-target)/2;
         */
        // Calculate the second sum based on the total sum and the target
        //s1+s2=totalSum
        //s1=totalSum-s2;

        //Also given
        //s1-s2=target
        //totalSum-s2-s2=target
        //s2=(target-totalSum)/2;
        int s2 = (totalSum - target) / 2;

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][s2 + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the countPartitionsUtil function to calculate the number of ways
        return findWays(n, s2, arr);
    }

    /*//recur+memo
    private static int findWays(int n, int s2, int[] arr) {
        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][s2 + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the countPartitionsUtil function to calculate the number of ways
        return findWaysUtils(n - 1, s2, arr, dp);
    }

    private static int findWaysUtils(int ind, int target, int[] arr, int[][] dp) {
        //base case
        if (ind == 0) {
            if (target == 0 && arr[ind] == 0) {
                return 2; // Both take and not take cases
            }
            if (target == 0 || arr[0] == target) {
                return 1; // Either not take or take case
            }
            return 0;
        }
        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int notTaken = findWaysUtils(ind - 1, target, arr, dp);
        int taken = 0;
        if (arr[ind] <= target) {
            taken = findWaysUtils(ind - 1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = notTaken + taken;
    }*/

    /*//tabulation
    private static int findWays(int n, int s2, int[] arr) {
        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][s2 + 1];
        //base case
        *//*if (ind == 0) {
            if (target == 0 && arr[ind] == 0) {
                return 2; // Both take and not take cases
            }
            if (target == 0 || arr[0] == target) {
                return 1; // Either not take or take case
            }
            return 0;
        }*//*
        if (arr[0] == 0) {
            dp[0][0] = 2;// 2 cases - pick and not pick
        } else {
            dp[0][0] = 1;
            if (arr[0] <= s2) {
                dp[0][arr[0]] = 1; // One way: take it
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= s2; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = notTaken + taken;
            }
        }


        return dp[n - 1][s2];
    }*/

    //space
    private static int findWays(int n, int s2, int[] arr) {
        // Create a 2D array to store results of subproblems
        int prev[] = new int[s2 + 1];
        //base case
        if (arr[0] == 0) {
            prev[0] = 2;// 2 cases - pick and not pick
        } else {
            prev[0] = 1;
            if (arr[0] <= s2) {
                prev[arr[0]] = 1; // One way: take it
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int cur[] = new int[s2 + 1];
            for (int target = 0; target <= s2; target++) {
                int notTaken = prev[target];
                int taken = 0;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                cur[target] = notTaken + taken;
            }
            prev = cur;
        }


        return prev[s2];
    }
}


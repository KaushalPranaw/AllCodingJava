package Leetcode.DP.DP00_1D_2D;

//similar to house robber

import java.util.Arrays;
import java.util.Map;

//Problem Statement:
//https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
public class DP05_MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        // Input array with elements.
        int arr[] = {2, 1, 4, 9};

        // Get the length of the array.
        int n = arr.length;

        // Call the solve function to find the maximum possible sum.
        int result = maximumSumOfNonAdjacentElements(n, arr);

        // Print the result.
        System.out.println(result);
    }

    //recur+memo
    /*private static int maximumSumOfNonAdjacentElements(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maximumSumOfNonAdjacentElementsHelper(n - 1, arr, dp);
    }

    private static int maximumSumOfNonAdjacentElementsHelper(int ind, int[] arr, int[] dp) {
        //base case
        if (ind == 0) {
            return arr[ind];
        }
        if (ind < 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int take = arr[ind] + maximumSumOfNonAdjacentElementsHelper(ind - 2, arr, dp);
        int skip = maximumSumOfNonAdjacentElementsHelper(ind - 1, arr, dp);
        return dp[ind] = Math.max(take, skip);
    }*/

    //bottom up
    /*private static int maximumSumOfNonAdjacentElements(int n, int[] arr) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int ind = 1; ind < n; ind++) {
            int take = 0;
            if (ind - 2 >= 0) {
                take = arr[ind] + dp[ind - 2];
            }
            int skip = dp[ind - 1];
            dp[ind] = Math.max(take, skip);
        }
        return dp[n - 1];
    }*/

    //space
    private static int maximumSumOfNonAdjacentElements(int n, int[] arr) {
        int prev2 = 0;
        int prev = arr[0];
        for (int ind = 1; ind < n; ind++) {
            int take = 0;
            if (ind - 2 >= 0) {
                take = arr[ind] + prev2;
            }
            int skip = prev;
            int cur = Math.max(take, skip);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}

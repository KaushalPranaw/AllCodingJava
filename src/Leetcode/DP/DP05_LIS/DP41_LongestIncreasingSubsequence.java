package Leetcode.DP.DP05_LIS;

import java.util.Arrays;
import java.util.Map;

public class DP41_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
    }

    //recur+memo
    /*private static int longestIncreasingSubsequence(int[] arr, int n) {
        //since we are starting prev from -1 so
        //ind->n
        //prevInd->n+1
        int[][] dp = new int[n][n + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return longestIncreasingSubsequenceHelper(0, -1, arr, n, dp);
    }

    private static int longestIncreasingSubsequenceHelper(int ind, int prevInd, int[] arr, int n, int[][] dp) {
        //base case
        if (ind == n) {
            return 0;
        }

        if (dp[ind][prevInd + 1] != -1) {
            return dp[ind][prevInd + 1];
        }

        int notTake = 0 + longestIncreasingSubsequenceHelper(ind + 1, prevInd, arr, n, dp);
        int take = 0;
        if (prevInd == -1 || arr[ind] > arr[prevInd]) {
            take = 1 + longestIncreasingSubsequenceHelper(ind + 1, ind, arr, n, dp);
        }
        return dp[ind][prevInd + 1] = Math.max(take, notTake);
    }*/

    //tabulation
    /*private static int longestIncreasingSubsequence(int[] arr, int n) {
        int[][] dp = new int[n + 1][n + 1];
        //since we are calling in ind+1 in loop that is why we have to take n+1


        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                //prevInd can be -1, which will cause: ArrayIndexOutOfBoundsException
                //We need to offset prevInd by +1
                // prevInd is shifted by 1 jaha jaha bhi dp me use kr rhe h

                int not_take = 0 + dp[ind + 1][prevInd + 1];// shifted index
                int take = 0;
                if (prevInd == -1 || arr[ind] >= arr[prevInd]) {
                    take = 1 + dp[ind + 1][ind + 1]; // shifted index
                }
                dp[ind][prevInd + 1] = Math.max(take, not_take); // shifted index
            }
        }

        return dp[0][-1 + 1];// shifted index
    }*/

    //space
    /*private static int longestIncreasingSubsequence(int[] arr, int n) {
        int[] cur = new int[n + 1];
        int[] next = new int[n + 1];
        //since we are calling in ind+1 in loop that is why we have to take n+1


        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                //prevInd can be -1, which will cause: ArrayIndexOutOfBoundsException
                //We need to offset prevInd by +1
                // prevInd is shifted by 1 jaha jaha bhi dp me use kr rhe h

                int not_take = 0 + next[prevInd + 1];// shifted index
                int take = 0;
                if (prevInd == -1 || arr[ind] >= arr[prevInd]) {
                    take = 1 + next[ind + 1]; // shifted index
                }
                cur[prevInd + 1] = Math.max(take, not_take); // shifted index
            }
            next=cur.clone();
        }

        return next[-1 + 1];// shifted index
    }*/

    //more optimize using one dp array
    private static int longestIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i]) {
                    //dp[i]	-> Not taking arr[prev], start fresh at arr[i]
                    //1 + dp[prev] -> Taking arr[i] after arr[prev]
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

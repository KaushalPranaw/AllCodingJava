package Comp.CodeWithComplexity75.DP;

import java.util.Arrays;

public class C18_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new C18_LongestIncreasingSubsequence().lengthOfLIS(nums));

    }

    /*//recur+memo
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //since we are starting prev from -1 so
        //ind->n
        //prevInd->n+1
        int[][] dp = new int[n][n + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return lengthOfLISHelper(0, -1, nums, dp);

    }

    private int lengthOfLISHelper(int ind, int prevInd, int[] nums, int[][] dp) {
        int n = nums.length;
        //base case
        if (ind == n) {
            return 0;//out of loop
        }

        //prevInd=prevInd+1 since staring from -1 and Array starts from 0
        //so keep prevInd+1 every where

        if (dp[ind][prevInd + 1] != -1) {
            return dp[ind][prevInd + 1];
        }

        int notTake = 0 + lengthOfLISHelper(ind + 1, prevInd, nums, dp);
        int take = 0;
        if (prevInd == -1 || nums[ind] > nums[prevInd]) {
            take = 1 + lengthOfLISHelper(ind + 1, ind, nums, dp);
        }

        return dp[ind][prevInd + 1] = Math.max(take, notTake);
    }*/

    //tabulation
    /*public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //since we are calling in ind+1 in loop that is why we have to take n+1
        int[][] dp = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                int notTake = 0 + dp[ind + 1][prevInd + 1];
                int take = 0;
                if (prevInd == -1 || nums[ind] > nums[prevInd]) {
                    take = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prevInd + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][-1 + 1];

    }*/

    //space
    /*public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //since we are calling in ind+1 in loop that is why we have to take n+1
        int[] cur = new int[n + 1];
        int[] next = new int[n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                int notTake = 0 + next[prevInd + 1];
                int take = 0;
                if (prevInd == -1 || nums[ind] > nums[prevInd]) {
                    take = 1 + next[ind + 1];
                }

                cur[prevInd + 1] = Math.max(take, notTake);
            }
            next=cur.clone();
        }

        return next[-1 + 1];

    }*/

    //more optimize
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
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

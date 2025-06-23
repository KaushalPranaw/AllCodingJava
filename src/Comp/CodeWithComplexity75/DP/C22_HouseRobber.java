package Comp.CodeWithComplexity75.DP;

import java.util.Arrays;

public class C22_HouseRobber {
    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};

        int result = new C22_HouseRobber().rob(arr);
        System.out.println(result);
    }

    /*//recur+memo
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, nums, dp);
    }

    private int helper(int ind, int[] nums, int[] dp) {
        if (ind == 0) {
            return nums[ind];
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        if (ind < 0) {
            return 0;
        }

        int skip = helper(ind - 1, nums, dp);
        int take = nums[ind] + helper(ind - 2, nums, dp);
        return dp[ind] = Math.max(skip, take);
    }*/

    /*//tab
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;          // No houses to rob
        if (n == 1) return nums[0];    // Only one house to rob

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int ind = 2; ind < n; ind++) {
            int skip = dp[ind - 1];
            int take = 0;
            take = nums[ind] + dp[ind - 2];

            dp[ind] = Math.max(skip, take);
        }
        return dp[n - 1];
    }*/

    //tab
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;          // No houses to rob
        if (n == 1) return nums[0];    // Only one house to rob

        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int ind = 2; ind < n; ind++) {
            int skip = prev;
            int take = nums[ind] + prev2;

            int cur = Math.max(skip, take);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

}

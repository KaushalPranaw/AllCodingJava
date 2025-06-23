package Comp.CodeWithComplexity75.DP;

import java.util.Arrays;

public class C21_CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new C21_CombinationSumIV().combinationSum4(nums, target));
    }

    /*//recur+memo
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1); // Initialize with -1 to indicate uncomputed states
        dp[0] = 1; // Base case: one way to make sum 0 (using no numbers)
        return helper(nums, target, dp);
    }

    private int helper(int[] nums, int target, int[] dp) {
        if (target < 0) return 0; // No solution if target becomes negative
        if (dp[target] != -1) return dp[target]; // Return memoized result if available

        int count = 0;
        for (int num : nums) {
            count += helper(nums, target - num, dp); // Try all possible numbers
        }
        return dp[target] = count; // Memoize the result
    }*/

    //tab
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to make sum 0 (using no numbers)
        for (int t = 1; t <= target; t++) {
            for (int num : nums) {
                if (t - num >= 0) {
                    dp[t] += dp[t - num];
                }
            }
        }
        return dp[target];
    }
}

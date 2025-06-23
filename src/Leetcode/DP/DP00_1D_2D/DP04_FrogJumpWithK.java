package Leetcode.DP.DP00_1D_2D;

import java.util.Arrays;

public class DP04_FrogJumpWithK {
    public static void main(String[] args) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        System.out.println(frogJumpWithK(n, height, k));
    }

    //recur+memo
    /*private static int frogJumpWithK(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpWithKHelper(n - 1, height, k, dp);
    }

    private static int frogJumpWithKHelper(int ind, int[] height, int k, int[] dp) {
        //base case
        if (ind == 0) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }
        int minStep = Integer.MAX_VALUE;
        for (int jump = 1; jump <= k; jump++) {
            if (ind - jump >= 0) {
                int cur = Math.abs(height[ind] - height[ind - jump]) + frogJumpWithKHelper(ind - jump, height, k, dp);
                minStep = Math.min(cur, minStep);
            }

        }
        return dp[ind] = minStep;
    }*/

    //tabulation
    private static int frogJumpWithK(int n, int[] height, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int minStep = Integer.MAX_VALUE;
            for (int jump = 1; jump <= k; jump++) {
                if (ind - jump >= 0) {
                    int cur = Math.abs(height[ind] - height[ind - jump]) + dp[ind - jump];
                    minStep = Math.min(cur, minStep);
                }
            }
            dp[ind] = minStep;
        }
        return dp[n - 1];
    }
}

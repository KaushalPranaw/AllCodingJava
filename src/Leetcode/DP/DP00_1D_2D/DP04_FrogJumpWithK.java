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
        int minJump = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = Math.abs(height[ind] - height[ind - j])
                        + frogJumpWithKHelper(ind - j, height, k, dp);
                minJump = Math.min(minJump, jump);
            }
        }
        return dp[ind] = minJump;

    }*/

    //tabulation
    private static int frogJumpWithK(int n, int[] height, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int minJump = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (ind - j >= 0) {
                    int jump = Math.abs(height[ind] - height[ind - j])
                            + dp[ind - j];
                    minJump = Math.min(minJump, jump);
                }
            }
            dp[ind] = minJump;
        }
        return dp[n - 1];
    }
}

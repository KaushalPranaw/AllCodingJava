package Leetcode.DP.DP00_1D_2D;

import java.util.Arrays;
import java.util.Map;

//https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
public class DP03_FrogJump {
    public static void main(String[] args) {
        int height[] = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJump(height));
    }

    //recur+memo
    /*private static int frogJump(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpHelper(n - 1, height, dp);
    }

    private static int frogJumpHelper(int ind, int[] height, int[] dp) {
        //base case
        if (ind == 0) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int jumpOne = Math.abs(height[ind] - height[ind - 1]) + frogJumpHelper(ind - 1, height, dp);
        int jumpTwo = Integer.MAX_VALUE;
        if (ind - 2 >= 0)
            jumpTwo = Math.abs(height[ind] - height[ind - 2]) + frogJumpHelper(ind - 2, height, dp);

        return dp[ind] = Math.min(jumpTwo, jumpOne);
    }*/

    //tabulation
    /*private static int frogJump(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int jumpOne = Math.abs(height[ind] - height[ind - 1]) + dp[ind - 1];
            int jumpTwo = Integer.MAX_VALUE;
            if (ind - 2 >= 0)
                jumpTwo = Math.abs(height[ind] - height[ind - 2]) + dp[ind - 2];

            dp[ind] = Math.min(jumpTwo, jumpOne);
        }
        return dp[n-1];
    }*/

    //space optimize
    private static int frogJump(int[] height) {
        int n = height.length;
        int prev = 0;
        int prev2 = 0;
        for (int ind = 1; ind < n; ind++) {
            int jumpOne = Math.abs(height[ind] - height[ind - 1]) + prev;
            int jumpTwo = Integer.MAX_VALUE;
            if (ind - 2 >= 0)
                jumpTwo = Math.abs(height[ind] - height[ind - 2]) + prev2;

            int cur = Math.min(jumpTwo, jumpOne);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}

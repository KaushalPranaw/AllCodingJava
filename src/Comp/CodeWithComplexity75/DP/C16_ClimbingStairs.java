package Comp.CodeWithComplexity75.DP;

import java.util.Arrays;

public class C16_ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new C16_ClimbingStairs().climbStairs(n));//3
    }

    //recur+memo
    /*public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsHelper(n, dp);
    }


    private int climbStairsHelper(int i, int[] dp) {
        if (i == 0) {
            return 1;
        }

        if (i == 1) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int jump1 = climbStairsHelper(i - 1, dp);
        int jump2 = climbStairsHelper(i - 2, dp);
        return dp[i] = jump1 + jump2;
    }*/

    /*//bottom up
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int jump1 = dp[i - 1];
            int jump2 = dp[i - 2];
            dp[i] = jump1 + jump2;
        }
        return dp[n];
    }*/

    //space
    public int climbStairs(int n) {
        int prev = 1;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int jump1 = prev;
            int jump2 = prev2;
            int cur = jump1 + jump2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}

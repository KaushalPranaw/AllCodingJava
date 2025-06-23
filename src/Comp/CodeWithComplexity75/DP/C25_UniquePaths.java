package Comp.CodeWithComplexity75.DP;

import java.util.Arrays;

public class C25_UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        C25_UniquePaths o = new C25_UniquePaths();
        System.out.println(o.uniquePaths(m, n));

    }

    /*//recur+memo
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, -1));
        return helper(m - 1, n - 1, dp);

    }

    private int helper(int i, int j, int[][] dp) {
        //base case
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = helper(i - 1, j, dp);
        int left = helper(i, j - 1, dp);
        return dp[i][j] = up + left;

    }*/

    /*//recur+memo
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                if (i - 1 >= 0) {
                    up = dp[i - 1][j];
                }
                int left = 0;
                if (j - 1 >= 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];

    }*/

    //recur+memo
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = 1;
                    continue;
                }
                int up = 0;
                if (i - 1 >= 0) {
                    up = prev[j];
                }
                int left = 0;
                if (j - 1 >= 0) {
                    left = cur[j - 1];
                }
                cur[j] = up + left;
            }
            prev = cur.clone();
        }

        return prev[n - 1];

    }

}

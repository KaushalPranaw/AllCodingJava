package Leetcode.DP.DP01_Grid;

import java.util.Arrays;

//https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/
public class DP08_GridUniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 2;
        DP08_GridUniquePaths o = new DP08_GridUniquePaths();
        System.out.println(o.uniquePaths(m, n));
    }

    //recur+memo
    /*public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePathsHelper(m - 1, n - 1, dp);
    }

    private int uniquePathsHelper(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = uniquePathsHelper(i - 1, j, dp);
        int left = uniquePathsHelper(i, j - 1, dp);
        return dp[i][j] = up + left;
    }*/

    //tab
    /*public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                int left = 0;
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];

    }*/

    //space
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
                if (i > 0) {
                    up = prev[j];
                }
                int left = 0;
                if (j > 0) {
                    left = cur[j - 1];
                }
                cur[j] = up + left;
            }
            prev = cur;
        }
        return prev[n - 1];

    }
}

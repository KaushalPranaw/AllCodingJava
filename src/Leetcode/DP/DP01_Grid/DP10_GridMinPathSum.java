package Leetcode.DP.DP01_Grid;

import java.util.Arrays;
import java.util.Map;

/*

We are given an “N*M” matrix of integers.
We need to find a path from the top-left corner to the bottom-right corner of the matrix,
such that there is a minimum cost past that we select.

At every cell, we can move in only two directions: right and bottom.
The cost of a path is given as the sum of values of cells of the given matrix.
 */
public class DP10_GridMinPathSum {
    public static void main(String[] args) {
        // Define the matrix
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };

        int m = matrix.length;
        int n = matrix[0].length;

        // Calculate and print the minimum sum path in the matrix
        System.out.println(minSumPath(m, n, matrix));
    }

    //recur+memo
    /*private static int minSumPath(int m, int n, int[][] matrix) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minSumPathHelper(m - 1, n - 1, matrix, dp);
    }

    private static int minSumPathHelper(int i, int j, int[][] matrix, int[][] dp) {
        //base case
        if (i < 0 || j < 0) {
            return 10000000;
        }

        if (i == 0 && j == 0) {
            return matrix[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = matrix[i][j] + minSumPathHelper(i - 1, j, matrix, dp);
        int left = matrix[i][j] + minSumPathHelper(i, j - 1, matrix, dp);
        return dp[i][j] = Math.min(up, left);
    }*/

    //tabulation
    /*private static int minSumPath(int m, int n, int[][] matrix) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int up = 0;
                if (i > 0) {
                    up = matrix[i][j] + dp[i - 1][j];
                } else {
                    up = Integer.MAX_VALUE;
                }
                int left = 0;
                if (j > 0) {
                    left = matrix[i][j] + dp[i][j - 1];
                } else {
                    left = Integer.MAX_VALUE;
                }
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[m - 1][n - 1];
    }*/

    //space
    private static int minSumPath(int m, int n, int[][] matrix) {
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cur[j] = matrix[i][j];
                    continue;
                }
                int up = 0;
                if (i > 0) {
                    up = matrix[i][j] + prev[j];
                } else {
                    up = Integer.MAX_VALUE;
                }
                int left = 0;
                if (j > 0) {
                    left = matrix[i][j] + cur[j - 1];
                } else {
                    left = Integer.MAX_VALUE;
                }
                cur[j] = Math.min(up, left);
            }
            prev = cur;
        }
        return prev[n - 1];
    }
}

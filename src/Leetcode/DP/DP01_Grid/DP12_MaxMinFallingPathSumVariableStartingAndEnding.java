package Leetcode.DP.DP01_Grid;

import java.util.Arrays;

public class DP12_MaxMinFallingPathSumVariableStartingAndEnding {
    /*
   We are given an ‘N*M’ matrix.
   We need to find the maximum path sum
   from any cell of the first row to any cell of the last row.

    At every cell we can move in three directions:
    to the bottom cell (↓), to the bottom-right cell(↘),
    or to the bottom-left cell(↙).*/
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};

        // Call the getMaxPathSum function and print the result
        System.out.println(getMaxPathSum(matrix));
    }

    //recur+memo
    /*private static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            int ans = getMaxPathSumHelper(m - 1, j, n, matrix, dp);
            max = Math.max(max, ans);
        }
        return max;
    }

    private static int getMaxPathSumHelper(int i, int j, int n, int[][] matrix, int[][] dp) {

        //base case
        if (j < 0 || j >= n) {
            return -10000000;
        }

        if (i == 0) {
            return matrix[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up = matrix[i][j] + getMaxPathSumHelper(i - 1, j, n, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMaxPathSumHelper(i - 1, j - 1, n, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMaxPathSumHelper(i - 1, j + 1, n, matrix, dp);
        return dp[i][j]=Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }*/

    //tabulation
    /*private static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxi = Integer.MIN_VALUE;

        int[][] dp = new int[m][n];

        //initialize first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j];
                up += dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal = -10000000;
                }
                int rightDiagonal = matrix[i][j];
                if (j + 1 < n) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal = -10000000;
                }
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        for (int j = 0; j < n; j++) {
            int ans = dp[m - 1][j];
            maxi = Math.max(maxi, ans);
        }
        return maxi;
    }*/

    //space
    private static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxi = Integer.MIN_VALUE;

        int[] prev = new int[n];

        //initialize first row
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j];
                up += prev[j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev[j - 1];
                } else {
                    leftDiagonal = -10000000;
                }
                int rightDiagonal = matrix[i][j];
                if (j + 1 < n) {
                    rightDiagonal += prev[j + 1];
                } else {
                    rightDiagonal = -10000000;
                }
                cur[j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
            prev = cur.clone();
        }

        for (int j = 0; j < n; j++) {
            int ans = prev[j];
            maxi = Math.max(maxi, ans);
        }
        return maxi;
    }
}

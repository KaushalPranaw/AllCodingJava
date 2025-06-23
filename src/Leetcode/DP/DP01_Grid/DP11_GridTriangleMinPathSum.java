package Leetcode.DP.DP01_Grid;

import java.util.Arrays;

/*
We are given a Triangular matrix. We need to find the minimum path sum from the first row to the last row.

At every cell we can move in only two directions: either to the bottom cell (↓) or to the bottom-right cell(↘)
 */
public class DP11_GridTriangleMinPathSum {
    public static void main(String[] args) {
        int triangle[][] =
                {
                        {1},
                        {2, 3},
                        {3, 6, 7},
                        {18, 9, 6, 10}
                };

        int m = triangle.length;

        // Call the minimumPathSum function and print the result
        System.out.println(minimumPathSum(triangle, m));
    }

    //recur+memo
    /*private static int minimumPathSum(int[][] triangle, int m) {
        int[][] dp = new int[m][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumPathSumHelper(triangle, 0, 0, m, dp);
    }

    private static int minimumPathSumHelper(int[][] triangle, int i, int j, int m, int[][] dp) {

        //base case
        if (i == m - 1) {
            return triangle[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down = triangle[i][j] + minimumPathSumHelper(triangle, i + 1, j, m, dp);
        int diagonal = triangle[i][j] + minimumPathSumHelper(triangle, i + 1, j + 1, m, dp);
        return dp[i][j]=Math.min(down, diagonal);
    }*/

    //tabulation (top-down)
    /*private static int minimumPathSum(int[][] triangle, int m) {
        int[][] dp = new int[m][m];

        //for last row fill dp
        for (int j = 0; j < m; j++) {
            dp[m - 1][j] = triangle[m - 1][j];
        }

        // Starting from the second to last row
        for (int i = m - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i+1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }*/

    //space
    private static int minimumPathSum(int[][] triangle, int m) {

        int[] front = new int[m];

        //for last row fill dp
        for (int j = 0; j < m; j++) {
            front[j] = triangle[m - 1][j];
        }

        // Starting from the second to last row
        for (int i = m - 2; i >= 0; i--) {
            int[] cur = new int[m];
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];
                cur[j] = Math.min(down, diagonal);
            }
            front=cur.clone();
        }
        return front[0];
    }
}

package Leetcode.DP.DP01_Grid;

import java.util.Arrays;

/*
We are given an “N*M” Maze.
The maze contains some obstacles.
A cell is ‘blockage’ in the maze if its value is -1. 0 represents non-blockage.
There is no path possible through a blocked cell.

We need to count the total number of unique paths from the top-left corner
of the maze to the bottom-right corner.
At every cell, we can move either down or towards the right.
 */
public class DP09_GridUniquePath2 {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        int m = maze.length;
        int n = maze[0].length;
        DP09_GridUniquePath2 o = new DP09_GridUniquePath2();
        System.out.println(o.uniquePaths(m, n, maze));
    }

    //recur+memo
    /*public int uniquePaths(int m, int n, int[][] maze) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePathsHelper(m - 1, n - 1, maze, dp);
    }

    private int uniquePathsHelper(int i, int j, int[][] maze, int[][] dp) {
        if (i == 0 && j == 0 && maze[i][j] != -1) {
            return 1;
        }
        if (i > 0 && j > 0 && maze[i][j] == -1) {
            return 0;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = uniquePathsHelper(i - 1, j, maze, dp);
        int left = uniquePathsHelper(i, j - 1, maze, dp);
        return dp[i][j] = up + left;

    }*/

    //tabulation
    /*public int uniquePaths(int m, int n, int[][] maze) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 && maze[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

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

    //space optimize
    public int uniquePaths(int m, int n, int[][] maze) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 && maze[i][j] == -1) {
                    cur[j] = 0;
                    continue;
                }

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
            prev=cur;
        }
        return prev[n - 1];
    }
}

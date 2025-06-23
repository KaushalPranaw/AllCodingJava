package Leetcode.DP.DP01_Grid;

import java.util.Arrays;

//https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/
public class DP13_CherryPickII_3D_DP {
    /*We are given an ‘N*M’ matrix.
    Every cell of the matrix has some chocolates on it,
    mat[i][j] gives us the number of chocolates.
    We have two friends ‘Alice’ and ‘Bob’. initially,
    Alice is standing on the cell(0,0) and Bob is standing on the cell(0, M-1).
    Both of them can move only to the cells below them in these three directions:
    to the bottom cell (↓), to the bottom-right cell(↘), or to the bottom-left cell(↙).

    When Alica and Bob visit a cell,
    they take all the chocolates from that cell with them.
    It can happen that they visit the same cell,
    in that case, the chocolates need to be considered only once.

    They cannot go out of the boundary of the given matrix,
    we need to return the maximum number of chocolates
    that Bob and Alice can together collect.*/
    public static void main(String[] args) {
        int matrix[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int m = matrix.length;
        int n = matrix[0].length;

        // Call the maximumChocolates function and print the result
        System.out.println(maximumChocolates(m, n, matrix));
    }

    //recur+memo
    /*private static int maximumChocolates(int m, int n, int[][] matrix) {
        int[][][] dp = new int[m][n][n];
        for (int[][] dp1 : dp) {
            for (int[] row : dp1) {
                Arrays.fill(row, -1);
            }
        }

        return maximumChocolatesUtil(0, 0, n - 1, m, n, matrix, dp);
    }

    private static int maximumChocolatesUtil(int i, int j1, int j2, int m, int n, int[][] matrix, int[][][] dp) {

        //going top to bottom

        //base case
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return -10000000;
        }

        // If we are at the last row, return the sum of chocolates in the selected columns
        if (i == m - 1) {
            if (j1 == j2) {
                return matrix[i][j1];
            } else {
                return matrix[i][j1] + matrix[i][j2];
            }
        }
        // If the result for this state is already computed, return it
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int max = Integer.MIN_VALUE;
        // Iterate through possible moves in the next row (-1, 0, 1)
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                // If j1 and j2 are the same, add chocolates from grid[i][j1] only
                if (j1 == j2) {
                    ans = matrix[i][j1] + maximumChocolatesUtil(i + 1, j1 + di, j2 + dj, m, n, matrix, dp);
                } else {
                    // Add chocolates from both j1 and j2
                    ans = matrix[i][j1] + matrix[i][j2] + maximumChocolatesUtil(i + 1, j1 + di, j2 + dj, m, n, matrix, dp);
                }
                max = Math.max(max, ans);
            }
        }
        return dp[i][j1][j2] = max;
    }*/

    //tabulation
    /*private static int maximumChocolates(int m, int n, int[][] matrix) {
        int[][][] dp = new int[m][n][n];
        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = matrix[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = matrix[m - 1][j1] + matrix[m - 1][j2];
                }
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int max = Integer.MIN_VALUE;
                    // Iterate through possible moves in the next row (-1, 0, 1)
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            // If j1 and j2 are the same, add chocolates from grid[i][j1] only
                            if (j1 == j2) {
                                ans = matrix[i][j1];
                            } else {
                                // Add chocolates from both j1 and j2
                                ans = matrix[i][j1] + matrix[i][j2];
                            }
                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= n) || (j2 + dj < 0 || j2 + dj >= n)) {
                                ans += (int) Math.pow(-10, 9);
                            } else {
                                ans += dp[i + 1][j1 + di][j2 + dj];
                            }
                            max = Math.max(max, ans);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][n - 1];
    }*/

    //space
    private static int maximumChocolates(int m, int n, int[][] matrix) {
        int[][] front = new int[n][n];
        //base case
        //for i=m-1 , j will vary
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    front[j1][j2] = matrix[m - 1][j1];
                } else {
                    front[j1][j2] = matrix[m - 1][j1] + matrix[m - 1][j2];
                }
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = m - 2; i >= 0; i--) {
            int[][] cur = new int[n][n];
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int ans;
                            if (j1 == j2)
                                ans = matrix[i][j1];
                            else
                                ans = matrix[i][j1] + matrix[i][j2];

                            if ((j1 + dj1 < 0 || j1 + dj1 >= n) || (j2 + dj2 < 0 || j2 + dj2 >= n))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + dj1][j2 + dj2];

                            maxi = Math.max(maxi, ans);
                        }
                    }

                    cur[j1][j2] = maxi;

                }
            }
            for (int a = 0; a < n; a++) {
                front[a] = cur[a].clone();
            }
        }

        return front[0][n - 1];
    }
}

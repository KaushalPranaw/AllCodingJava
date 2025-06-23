package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.Arrays;

public class G09_SurroundedRegion {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new G09_SurroundedRegion().solve(board);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int[][] vis = new int[m][n];

        /*//check for first & last row
        for (int j = 0; j < n; j++) {
            //check for first row
            if (board[0][j] == 'O') {
                dfs(0, j, m, n, board, vis, delrow, delcol);
            }

            //check for last row
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, m, n, board, vis, delrow, delcol);
            }
        }
        //check for first & last col
        for (int i = 0; i < m; i++) {
            //check for first col
            if (board[i][0] == 'O') {
                dfs(i, 0, m, n, board, vis, delrow, delcol);
            }

            //check for last col
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, m, n, board, vis, delrow, delcol);
            }
        }*/

        // Check all border cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(i, j, m, n, board, vis, delrow, delcol);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int m, int n, char[][] board, int[][] vis, int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = row + delrow[i];
            int nc = col + delcol[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0 && board[nr][nc] == 'O') {
                dfs(nr, nc, m, n, board, vis, delrow, delcol);
            }
        }

    }
}

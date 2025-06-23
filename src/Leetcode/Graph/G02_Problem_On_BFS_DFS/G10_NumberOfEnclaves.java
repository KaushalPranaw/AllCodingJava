package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class G10_NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        System.out.println(new G10_NumberOfEnclaves().numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> queue = new LinkedList<>();
        int[][] vis = new int[m][n];

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new Node(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nr = row + delrow[i];
                int nc = col + delcol[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    queue.add(new Node(nr, nc));
                    vis[nr][nc] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    record Node(int row, int col) {
    }

    /*public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        //first row & last row
        for (int i = 0; i < n; i++) {
            //first row
            if (grid[0][i] == 1 && vis[0][i] == 0) {
                dfs(0, i, vis, grid, delRow, delCol);
            }

            //last row
            if (grid[m - 1][i] == 1 && vis[m - 1][i] == 0) {
                dfs(m - 1, i, vis, grid, delRow, delCol);
            }
        }

        //first col & last col
        for (int i = 0; i < m; i++) {
            //first col
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, vis, grid, delRow, delCol);
            }

            //last row
            if (grid[i][n - 1] == 1 && vis[i][n - 1] == 0) {
                dfs(i, n - 1, vis, grid, delRow, delCol);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(int row, int col, int[][] vis, int[][] grid, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                dfs(nRow, nCol, vis, grid, delRow, delCol);
            }
        }
    }*/
}

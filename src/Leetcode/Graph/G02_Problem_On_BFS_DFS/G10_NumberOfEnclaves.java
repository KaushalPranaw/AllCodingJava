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

    //using bfs
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();

        //first row & last row
        for (int j = 0; j < n; j++) {
            //first row
            if (grid[0][j] == 1) {
                queue.add(new int[]{0, j});
                vis[0][j] = 1;
            }
            //last row
            if (grid[m - 1][j] == 1) {
                queue.add(new int[]{m - 1, j});
                vis[m - 1][j] = 1;
            }
        }

        //first col & last col
        for (int i = 0; i < m; i++) {
            //first col
            if (grid[i][0] == 1) {
                queue.add(new int[]{i, 0});
                vis[i][0] = 1;
            }
            //last col
            if (grid[i][n - 1] == 1) {
                queue.add(new int[]{i, n - 1});
                vis[i][n - 1] = 1;
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = r + delrow[i];
                int nc = c + delcol[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc});
                    vis[nr][nc] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    /*//using dfs
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        //first row & last row
        for (int j = 0; j < n; j++) {
            //first row
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                dfs(0, j, grid, vis, delrow, delcol);
            }
            //last row
            if (grid[m - 1][j] == 1 && vis[m - 1][j] == 0) {
                dfs(m - 1, j, grid, vis, delrow, delcol);
            }
        }

        //first col & last col
        for (int i = 0; i < m; i++) {
            //first col
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, grid, vis, delrow, delcol);
            }
            //last col
            if (grid[i][n - 1] == 1 && vis[i][n - 1] == 0) {
                dfs(i, n - 1, grid, vis, delrow, delcol);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;

    }

    private void dfs(int r, int c, int[][] grid, int[][] vis, int[] delrow, int[] delcol) {
        int m = grid.length;
        int n = grid[0].length;
        vis[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + delrow[i];
            int nc = c + delcol[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && vis[nr][nc] == 0) {
                dfs(nr, nc, grid, vis, delrow, delcol);
            }
        }
    }*/
}

package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class G08_NumberOfIslands {
    public static void main(String[] args) {
        G08_NumberOfIslands solution = new G08_NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int numIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numIslands); // Output: 3
    }

    private int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, char[][] grid, int[][] vis) {
        Queue<Node> queue = new LinkedList<>();
        vis[row][col] = 1;
        queue.add(new Node(row, col));
        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nrow = node.row() + delrow[i];
                int ncol = node.col() + delcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    queue.add(new Node(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

    }

    record Node(int row, int col) {

    }
}

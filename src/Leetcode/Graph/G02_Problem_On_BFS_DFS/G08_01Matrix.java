package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class G08_01Matrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        G08_01Matrix obj = new G08_01Matrix();
        int[][] ans = obj.nearest(grid);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int steps = queue.peek().steps;
            dist[row][col] = steps;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = row + delrow[i];
                int nc = col + delcol[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0) {
                    queue.add(new Node(nr, nc, steps + 1));
                    vis[nr][nc] = 1;
                }
            }
        }
        return dist;

    }

    record Node(int row, int col, int steps) {
    }
}

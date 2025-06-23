package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//https://takeuforward.org/data-structure/number-of-islands/
public class G13_NoOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };

        G13_NoOfIslands obj = new G13_NoOfIslands();
        System.out.println(obj.numIslands(grid));
    }

    private int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        vis[i][j] = true;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            int row = queue.peek()[0];
            int col = queue.peek()[1];
            queue.poll();

            for (int x = 0; x < 4; x++) {
                int nr = row + delrow[x];
                int nc = col + delcol[x];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && grid[nr][nc] == '1') {
                    queue.add(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }
    }
}

package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

//https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/
public class G04_RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        /*
        2,2,2
        2,2,0
        0,2,2
         */
        G04_RottenOranges o = new G04_RottenOranges();
        System.out.println(o.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<Node> queue = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if rotten orange
                if (grid[i][j] == 2) {
                    queue.add(new Node(i, j, 0));
                    vis[i][j] = 2;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            //no oranges to rot
            return -1;
        }
        int minutes = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int rottenOranges = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;
            int tm = node.tm;
            minutes = Math.max(minutes, tm);

            for (int i = 0; i < 4; i++) {
                int nr = r + delrow[i];
                int nc = c + delcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && vis[nr][nc] == 0) {
                    queue.add(new Node(nr, nc, tm + 1));
                    rottenOranges++;
                    vis[nr][nc] = 2;
                }
            }
        }
        if (rottenOranges == fresh) {
            return minutes;
        } else {
            return -1;
        }
    }

    record Node(int r, int c, int tm) {
    }
}

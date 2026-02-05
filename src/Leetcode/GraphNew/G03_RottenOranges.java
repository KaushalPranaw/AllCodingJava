package Leetcode.GraphNew;

import java.util.LinkedList;
import java.util.Queue;

public class G03_RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        /*
        2,2,2
        2,2,0
        0,2,2
         */
        G03_RottenOranges o = new G03_RottenOranges();
        System.out.println(o.orangesRotting(grid));
    }

    private int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //vis array and quue
        //push rotten into queue
        //count fresh

        //we can remove vis by updating grid
        //int[][] vis = new int[m][n];
        Queue<Node> queue = new LinkedList<>();


        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Node(i, j, 0));
                    //vis[i][j] = 2;
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }

        int minTime = 0;
        int rotten = 0;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.r();
            int c = node.c();
            int time = node.tm();
            minTime = Math.max(minTime, time);

            for (int i = 0; i < 4; i++) {
                int nr = r + delrow[i];
                int nc = c + delcol[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    rotten++;
                    //vis[nr][nc] = 2;
                    grid[nr][nc] = 2;   // add this
                    queue.add(new Node(nr, nc, time + 1));
                }
            }

        }


        if (fresh == rotten) {
            return minTime;
        } else {
            return -1;
        }
    }
}

record Node(int r, int c, int tm) {

}

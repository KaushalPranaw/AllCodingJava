package Leetcode.Leetcode150.GraphGeneral;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] visited = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && visited[row][col] == 0) {
                    count++;
                    bfs(row, col, grid, visited, rows, cols);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, char[][] grid, int[][] visited, int rows, int cols) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int first = pair.first();
            int second = pair.second();

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int i = 0; i < directions.length; i++) {
                int nr = first + directions[i][0];
                int nc = second + directions[i][1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    queue.add(new Pair(nr, nc));
                }
            }
        }
    }
}

record Pair(int first, int second) {
}



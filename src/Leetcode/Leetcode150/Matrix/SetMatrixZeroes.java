package Leetcode.Leetcode150.Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new SetMatrixZeroes().setZeroes(matrix);
        for (int[] r : matrix) {
            System.out.println(Arrays.toString(r));
        }
    }

    //using bfs graph
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            //set row to 0
            for (int j = 0; j < n; j++) {
                matrix[x][j] = 0;
            }
            //set col to 0
            for (int i = 0; i < m; i++) {
                matrix[i][y] = 0;
            }
        }
    }

    /*public void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }*/
}

package Leetcode.Leetcode150.Matrix;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new RotateImage().rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //transpose
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            reverseMat(matrix, i, l, r);
        }
    }

    private void reverseMat(int[][] matrix, int row, int l, int r) {
        while (l < r) {
            int temp = matrix[row][l];
            matrix[row][l] = matrix[row][r];
            matrix[row][r] = temp;
            l++;
            r--;
        }
    }
}

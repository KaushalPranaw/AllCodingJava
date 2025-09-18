package Leetcode.Matrix;

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
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }

        //reverse
        for(int i=0;i<m;i++){
            int left=0, right=n-1;
            while (left<right){
                int t=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=t;
                left++;
                right--;
            }
        }



    }
}

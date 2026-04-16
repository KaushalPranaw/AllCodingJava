package DSA2026.D06_Matrix;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        //Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        //Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix);

        // print result
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

    }
    public static void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        //transpose
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }


        //reverse
        for(int i=0;i<m;i++){
            //apply reverse
            int left=0, right=n-1;
            while (left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }

    }
}

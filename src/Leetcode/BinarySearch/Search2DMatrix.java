package Leetcode.BinarySearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(new Search2DMatrix().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[m - 1][n - 1] < target) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] >= target) {
                return binarySearch(i, matrix, target);
            }
        }
        return false;
    }

    private boolean binarySearch(int row, int[][] matrix, int target) {
        int n = matrix[0].length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}

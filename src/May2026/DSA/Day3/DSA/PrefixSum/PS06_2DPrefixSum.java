package May2026.DSA.Day3.DSA.PrefixSum;

public class PS06_2DPrefixSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] prefix = buildPrefix(matrix);

        int ans = query(prefix,
                1, 1,
                2, 2);

        System.out.println(ans);
    }

    private static int query(int[][] prefix, int r1, int c1, int r2, int c2) {
        //formula: sum(r1,c1,r2,c2)=total-left extra-top extra+overlap
        //means sum of submatrix from (r1,c1) to (r2,c2)=prefixSum[r2][c2]-prefixSum[r2][c1-1]-prefixSum[r1-1][c2]+prefixSum[r1-1][c1-1]
        int total = prefix[r2][c2];
        int leftExtra = c1 > 0 ? prefix[r2][c1 - 1] : 0;
        int topExtra = r1 > 0 ? prefix[r1 - 1][c2] : 0;
        int overlap = (r1 > 0 && c1 > 0) ? prefix[r1 - 1][c1 - 1] : 0;

        return total - leftExtra - topExtra + overlap;
    }

    private static int[][] buildPrefix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //build prefix sum array
        int[][] prefixSum = new int[m][n];

        //fill prefix sum array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //formula: prefixSum=current element + prefixSum of top + prefixSum of left - prefixSum of top-left
                int current = matrix[i][j];
                int top = i > 0 ? prefixSum[i - 1][j] : 0;
                int left = j > 0 ? prefixSum[i][j - 1] : 0;
                int overlap = (i > 0 && j > 0) ? prefixSum[i - 1][j - 1] : 0;

                //so prefixSum[i][j]=current+top+left-overlap
                prefixSum[i][j] = current + top + left - overlap;
            }
        }
        return prefixSum;
    }
}

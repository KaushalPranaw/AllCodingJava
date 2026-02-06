package Leetcode.GraphNew;

//https://leetcode.com/problems/flood-fill/description/
public class G04_FloodFillAlgorithm {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1, color = 2;

        int[][] ans = new G04_FloodFillAlgorithm().floodFill(image, sr, sc, color);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;   // ✅ IMPORTANT FIX
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        dfs(image, sr, sc, color, original, delrow, delcol);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int original, int[] delrow, int[] delcol) {
        image[r][c] = color;
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nr = r + delrow[i];
            int nc = c + delcol[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == original) {
                dfs(image, nr, nc, color, original, delrow, delcol);
            }

        }
    }
}

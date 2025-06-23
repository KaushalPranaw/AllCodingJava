package Leetcode.Graph.G02_Problem_On_BFS_DFS;

public class G05_FloodFillAlgorithm {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        // sr = 1, sc = 1, newColor = 2
        G05_FloodFillAlgorithm obj = new G05_FloodFillAlgorithm();
        int[][] ans = obj.floodFill(image, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];

        int[][] ans = image.clone();
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        dfs(image, sr, sc, newColor, initialColor, ans, delrow, delcol);
        return ans;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int initialColor, int[][] ans, int[] delrow, int[] delcol) {
        int m = image.length;
        int n = image[0].length;
        ans[sr][sc] = newColor;

        for (int i = 0; i < 4; i++) {
            int nr = sr + delrow[i];
            int nc = sc + delcol[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == initialColor
                    && ans[nr][nc] != newColor) {
                dfs(image, nr, nc, newColor, initialColor, ans, delrow, delcol);
            }

        }
    }
}

package Leetcode.GraphNew;

public class G02_NumberOfProvince_leetcode {
    public static void main(String[] args) {
        // Example input: a 3x3 adjacency matrix representing
        // connections between cities
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        // Create an instance of the class and call the findCircleNum method
        System.out.println(new G02_NumberOfProvince_leetcode().findCircleNum(isConnected));
    }

    private int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;//similar to V
        boolean[] vis = new boolean[m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }

    private void dfs(int i, int[][] mat, boolean[] vis) {
        vis[i] = true;
        for (int j = 0; j < mat[i].length; j++) {
            if (mat[i][j] == 1 && !vis[j]) {
                dfs(j, mat, vis);
            }
        }
    }
}

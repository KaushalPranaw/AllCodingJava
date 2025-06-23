package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class G03_NumberOfProvinces_Leetcode {
    public static void main(String[] args) {
        // Example input: a 3x3 adjacency matrix representing
        // connections between cities
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        // Create an instance of the class and call the findCircleNum method
        System.out.println(new G03_NumberOfProvinces_Leetcode().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        //m -> city which we have to visit
        int m = isConnected.length;
        boolean[] vis = new boolean[m];
        int count = 0;

        for (int i = 0; i < m; i++) {
            if (!vis[i]) {
                dfs(i, isConnected, vis);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, int[][] isConnected, boolean[] vis) {
        vis[node] = true;
        for (int j = 0; j < isConnected[node].length; j++) {
            if (isConnected[node][j] == 1 && !vis[j]) {
                dfs(j, isConnected, vis);
            }
        }
    }

    /*public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        int V = isConnected.length;

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, adjList, vis);
            }
        }
        return count;
    }

    // Depth-First Search (DFS) method
    private void dfs(int node, List<List<Integer>> adjList, boolean[] vis) {
        vis[node] = true;

        for (int neighbour : adjList.get(node)) {
            if (!vis[neighbour]) {
                dfs(neighbour, adjList, vis);
            }
        }
    }*/
}
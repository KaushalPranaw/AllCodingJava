package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class G03_NumberOfProvinces {
    public static void main(String[] args) {

        // adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        G03_NumberOfProvinces ob = new G03_NumberOfProvinces();
        System.out.println(ob.numProvinces(adj, 3));
    }

    private int numProvinces(List<List<Integer>> adj, int V) {
        int numOfProvince = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                numOfProvince++;
                dfs(i, adj, vis);
            }
        }
        return numOfProvince;

    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                dfs(neighbour, adj, vis);
            }
        }
    }
}

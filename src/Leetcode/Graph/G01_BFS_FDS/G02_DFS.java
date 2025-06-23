package Leetcode.Graph.G01_BFS_FDS;

import java.util.ArrayList;
import java.util.List;

public class G02_DFS {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 2, 4);

        G02_DFS obj = new G02_DFS();
        List<Integer> ans = obj.dfsOfGraph(V, adj);
        System.out.println(ans);
        System.out.println();
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    //If having one component
    /*private List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfsOfGraphHelper(0, vis, dfs, adj);
        return dfs;
    }*/

    //multiple disconnected components
    private List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsOfGraphHelper(i, vis, dfs, adj);
            }
        }
        return dfs;
    }

    private void dfsOfGraphHelper(int node, boolean[] vis, List<Integer> dfs, List<List<Integer>> adj) {
        vis[node] = true;
        dfs.add(node);
        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                dfsOfGraphHelper(neighbour, vis, dfs, adj);
            }
        }
    }
}

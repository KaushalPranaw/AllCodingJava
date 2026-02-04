package Leetcode.GraphNew;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G01_BFS_DFS {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);

        System.out.println("Adj List = " + adj);

        System.out.println(bfsOfGraph(V, adj));
        System.out.println(dfsOfGraph(V, adj));

    }

    private static List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                vis[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    bfs.add(node);
                    for (int neighbour : adj.get(node)) {
                        if (!vis[neighbour]) {
                            queue.add(neighbour);
                            vis[neighbour] = true;
                        }
                    }
                }
            }
        }
        return bfs;
    }

    private static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, dfs, vis, adj);
            }
        }
        return dfs;
    }

    private static void dfs(int node, List<Integer> dfs, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        dfs.add(node);

        for (int n : adj.get(node)) {
            if (!vis[n]) {
                dfs(n, dfs, vis, adj);
            }
        }
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

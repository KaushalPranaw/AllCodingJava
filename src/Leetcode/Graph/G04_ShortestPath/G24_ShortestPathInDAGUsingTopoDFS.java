package Leetcode.Graph.G04_ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/
public class G24_ShortestPathInDAGUsingTopoDFS {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {1, 2, 3},
                {4, 2, 2},
                {4, 5, 4},
                {2, 3, 6},
                {5, 3, 1}
        };

        int[] dist = new G24_ShortestPathInDAGUsingTopoDFS().shortestPath(n, m, edges, 0);
        System.out.println(Arrays.toString(dist));
    }

    public int[] shortestPath(int n, int m, int[][] edges, int src) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the adjacency list for the weighted directed graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjList.get(u).add(new Pair(v, wt));
        }

        // Step 1: Topological sort
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stack, adjList);
            }
        }

        // Step 2: Initialize distances
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: Relax nodes in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Pair it : adjList.get(u)) {
                    int v = it.node;
                    int wt = it.weight;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Step 4: Convert unreachable distances to -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;


    }

    private void topoSort(int node, boolean[] visited, Stack<Integer> stack, List<List<Pair>> adj) {
        visited[node] = true;

        for (Pair it : adj.get(node)) {
            if (!visited[it.node]) {
                topoSort(it.node, visited, stack, adj);
            }
        }
        stack.push(node);

    }

    record Pair(int node, int weight) {
    }
}

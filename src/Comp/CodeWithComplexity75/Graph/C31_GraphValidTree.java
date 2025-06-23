package Comp.CodeWithComplexity75.Graph;

import java.util.*;

public class C31_GraphValidTree {
    public static void main(String[] args) {

    }
    public boolean validTree(int n, int[][] edges) {
        // A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Create an adjacency list for the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Build the undirected graph
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // Set to track visited nodes
        Set<Integer> visited = new HashSet<>();

        // DFS from node 0, with -1 as its parent (no parent)
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        // Check if all nodes were visited (i.e., graph is connected)
        return visited.size() == n;
    }

    // Helper DFS function to detect cycles and visit all nodes
    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false; // cycle detected
        }

        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue; // skip the parent
            }
            if (!dfs(neighbor, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}

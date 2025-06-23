package Leetcode.Graph.G03_Topo;

import java.util.*;

public class G05_Topo_Using_DFS {
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        G05_Topo_Using_DFS obj = new G05_Topo_Using_DFS();
        ArrayList<Integer> result = obj.topologicalSort(V, adj);

        if (result.size() == V) {
            System.out.println("Topological Sort: " + result);
        } else {
            System.out.println("The graph contains a cycle and is not a DAG.");
        }
    }

    private ArrayList<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        boolean[] recursiveStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, stack, recursiveStack)) {
                    return new ArrayList<>();
                }
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!stack.isEmpty()) {
            topo.add(stack.pop());
        }
        return topo;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack, boolean[] recursiveStack) {
        vis[node] = true;
        recursiveStack[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, adj, vis, stack, recursiveStack)) {
                    return true;//having cycle
                }
            } else {
                if (recursiveStack[neighbour])
                    return true;
            }

        }

        recursiveStack[node] = false;
        stack.push(node);
        return false;
    }

}

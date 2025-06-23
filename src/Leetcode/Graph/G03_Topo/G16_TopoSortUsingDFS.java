package Leetcode.Graph.G03_Topo;

import java.util.ArrayList;
import java.util.Stack;

public class G16_TopoSortUsingDFS {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = G16_TopoSortUsingDFS.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, stack);
            }
        }

        int[] ans = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            ans[index++] = stack.pop();
        }
        return ans;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adj, vis, stack);
            }
        }
        stack.push(node);
    }
}

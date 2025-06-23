package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G14_BipartiteGraph {
    public static void main(String[] args) {
        //if we are able to colour a graph with two colours such that
        //no adjacent nodes have the same colour, it is called a bipartite graph.

        // V = 4, E = 4
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        G14_BipartiteGraph obj = new G14_BipartiteGraph();
        boolean ans = obj.isBipartite(4, adj);
        if (ans)
            System.out.println("1");
        else System.out.println("0");
    }

    private boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean dfs(int node, int col, int[] color, List<List<Integer>> adj) {
        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, adj) == false) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }
}

package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.ArrayList;

public class G07_DFS_Detect_Cycle_Undirected {
    public static void main(String[] args) {
        /*
        Keep visited[]
        Pass parent in DFS
        If neighbour is visited and neighbour ≠ parent → cycle
         */
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        G07_DFS_Detect_Cycle_Undirected obj = new G07_DFS_Detect_Cycle_Undirected();
        boolean ans = obj.isCycle(V, adj);
        if (ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        //we are starting from each node
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                return dfs(i, -1, adj, vis);
            }
        }
        return false;
    }

    private boolean dfs(int node, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, node, adj, vis)) {
                    return true;
                }
            } else {
                if (par != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }

}

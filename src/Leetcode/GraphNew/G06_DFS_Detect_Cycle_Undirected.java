package Leetcode.GraphNew;

import java.util.ArrayList;

public class G06_DFS_Detect_Cycle_Undirected {
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

        G06_DFS_Detect_Cycle_Undirected obj = new G06_DFS_Detect_Cycle_Undirected();
        boolean ans = obj.isCycle(V, adj);
        if (ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                //do not directly return
                if (dfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(int node, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                //do not directly return
                if (dfs(neighbour, node, adj, vis)) {
                    return true;
                }
            }else {
                if(neighbour!=par){
                    return true;
                }
            }
        }
        return false;
    }

}

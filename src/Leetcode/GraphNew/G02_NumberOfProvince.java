package Leetcode.GraphNew;

import java.util.ArrayList;
import java.util.List;

public class G02_NumberOfProvince {
    //mtlb hume number of independent component return krna hai, refer leetcode
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.get(0).add(0, 1);
        //means 0->0 pe edge hai so inserting 1 if not then inserting 0
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

        G02_NumberOfProvince ob = new G02_NumberOfProvince();
        System.out.println(ob.numProvinces(adj, 3));
    }

    private int numProvinces(List<List<Integer>> adj, int V) {
        int noOfProvince = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                noOfProvince++;
                dfs(i, adj, vis);
            }
        }
        return noOfProvince;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }
}

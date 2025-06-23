package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G06_BFS_Detect_Cycle_Undirected {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(i, new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        G06_BFS_Detect_Cycle_Undirected obj = new G06_BFS_Detect_Cycle_Undirected();
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
                if(detectCycle(i, adj, vis)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, -1));
        vis[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int par = queue.peek().parent;
            queue.poll();
            for (int neighbour : adj.get(node)) {
                if (!vis[neighbour]) {
                    queue.add(new Node(neighbour, node));
                    vis[neighbour] = true;
                } else {
                    if (par != neighbour) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    record Node(int node, int parent) {
    }

}

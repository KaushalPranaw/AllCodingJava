package Leetcode.Graph.G03_Topo;

import java.util.*;

//https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/
public class G21_FindEventualSafeStatesBFS {
    public static void main(String[] args) {
        int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        G21_FindEventualSafeStatesBFS obj = new G21_FindEventualSafeStatesBFS();
        List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);

        for (int node : safeNodes) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    private List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Step 1: Create a reversed graph
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                revAdj.get(v).add(u);// Reverse the edge
                indegree[u]++; // Count outgoing edges in the original graph
            }
        }

        // Step 2: BFS using queue
        List<Integer> safe = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Nodes with no outgoing edges in original (i.e., 0 indegree in reversed)
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe.add(node);

            for (int neighbor : revAdj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Sort the result as expected in increasing order
        Collections.sort(safe);
        return safe;
    }
}

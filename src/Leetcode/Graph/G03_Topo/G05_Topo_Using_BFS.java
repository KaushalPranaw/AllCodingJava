package Leetcode.Graph.G03_Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G05_Topo_Using_BFS {
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

        G05_Topo_Using_BFS obj = new G05_Topo_Using_BFS();
        List<Integer> result = obj.topologicalSort(V, adj);

        if (result.size() == V) {
            System.out.println("Topological Sort: " + result);
        } else {
            System.out.println("The graph contains a cycle and is not a DAG.");
        }
    }

    private List<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> topo = new ArrayList<>();

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if (topo.size() == V) {
            return topo;
        } else {
            return new ArrayList<>();
        }
    }

}

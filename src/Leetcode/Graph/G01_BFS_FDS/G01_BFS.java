package Leetcode.Graph.G01_BFS_FDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G01_BFS {
    public static void main(String[] args) {
        // Define the number of vertices in the graph
        int V = 5;

        // Create an adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize the adjacency list with empty lists for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected edges)
        addEdge(adj, 0, 1); // Add edge between vertex 0 and 1
        addEdge(adj, 0, 2); // Add edge between vertex 0 and 2
        addEdge(adj, 0, 3); // Add edge between vertex 0 and 3
        addEdge(adj, 2, 4); // Add edge between vertex 2 and 4

        // Create an instance of the G01_BFS class
        G01_BFS obj = new G01_BFS();

        // Perform Breadth-First Search (BFS) starting from vertex 0
        List<Integer> ans = obj.bfsOfGraph(V, adj);

        // Print the BFS traversal result
        System.out.println(ans);
    }

    // Helper method to add an undirected edge between two vertices
    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // Add v to the adjacency list of u
        adj.get(v).add(u); // Add u to the adjacency list of v
    }

    //if having one component
    /*private List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> bfs = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);

            for (int neighbour : adj.get(node)) {
                if (!vis[neighbour]) {
                    queue.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }

        return bfs;
    }*/

    //if having multiple component
    private List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> bfs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                vis[i] = true;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    bfs.add(node);

                    for (int neighbour : adj.get(node)) {
                        if (!vis[neighbour]) {
                            queue.add(neighbour);
                            vis[neighbour] = true;
                        }
                    }
                }
            }
        }
        return bfs;

    }
}

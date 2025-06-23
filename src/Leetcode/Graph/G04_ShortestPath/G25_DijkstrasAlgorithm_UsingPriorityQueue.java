package Leetcode.Graph.G04_ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G25_DijkstrasAlgorithm_UsingPriorityQueue {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int S = 0; // Source vertex

        // Initialize adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: For undirected graph, add both directions
        // For example: edge from 0 to 1 with weight 2
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 2)));

        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 4)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 1)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(1, 7)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 3)));

        G25_DijkstrasAlgorithm_UsingPriorityQueue sol = new G25_DijkstrasAlgorithm_UsingPriorityQueue();
        int[] dist = sol.dijkstra(V, adj, S);

        System.out.println("Shortest distances from source " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> Distance: " + dist[i]);
        }
    }

    private int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.add(new Pair(0, src));

        while (pq.size() != 0) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    record Pair(int distance, int node) {
    }
}

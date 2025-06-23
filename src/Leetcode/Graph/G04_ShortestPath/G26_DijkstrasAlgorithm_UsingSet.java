package Leetcode.Graph.G04_ShortestPath;

import java.util.*;

public class G26_DijkstrasAlgorithm_UsingSet {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int S = 0; // Source vertex

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges: Undirected graph
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

        G26_DijkstrasAlgorithm_UsingSet sol = new G26_DijkstrasAlgorithm_UsingSet();
        int[] dist = sol.dijkstra(V, adj, S);

        System.out.println("Shortest distances from source " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> Distance: " + dist[i]);
        }
    }

    private int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        TreeSet<Pair> set = new TreeSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair current = set.pollFirst(); // Get and remove the node with the smallest distance
            int u = current.node;

            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                if (dist[u] + weight < dist[v]) {
                    // Remove the old entry if it exists
                    set.remove(new Pair(v, dist[v]));
                    dist[v] = dist[u] + weight;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.distance == other.distance) {
                return Integer.compare(this.node, other.node);
            }
            return Integer.compare(this.distance, other.distance);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return distance == p.distance && node == p.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(distance, node);
        }
    }
}

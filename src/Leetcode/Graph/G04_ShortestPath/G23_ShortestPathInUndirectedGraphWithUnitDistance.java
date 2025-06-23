package Leetcode.Graph.G04_ShortestPath;

import java.util.*;

public class G23_ShortestPathInUndirectedGraphWithUnitDistance {
    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edges = {
                {0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6},
                {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };

        shortestPath(edges, n, m, 0);

    }

    public static void shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        //start node
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int it : adjList.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    queue.add(it);
                }
            }
        }

        Arrays.stream(dist).map(v -> {
            if (v == Integer.MAX_VALUE)
                return -1;
            else
                return v;
        }).forEach(System.out::println);


    }
}

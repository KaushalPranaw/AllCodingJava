package Leetcode.Graph.G03_Topo;

import java.util.*;

public class G17_TopoSortKahnAlgo {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = G17_TopoSortKahnAlgo.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree=new int[V];

        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        List<Integer> topo=new ArrayList<>();
        while (!queue.isEmpty()){
            int node=queue.poll();
            topo.add(node);

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }
        }
        return topo.stream().mapToInt(i->i).toArray();
    }
}

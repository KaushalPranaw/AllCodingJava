package Leetcode.Graph.G03_Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G22_AlienDictionary {
    public static void main(String[] args) {
        //N -> no of word in dictionary
        //K-> no of diff char
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        G22_AlienDictionary obj = new G22_AlienDictionary();
        String ans = obj.findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }

    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int x = 0; x < len; x++) {
                if (s1.charAt(x) != s2.charAt(x)) {
                    adj.get(s1.charAt(x) - 'a').add(s2.charAt(x) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        StringBuilder sb = new StringBuilder();
        for (int i : topo) {
            sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        return topo;
    }
}

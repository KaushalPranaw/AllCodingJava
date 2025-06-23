package Leetcode.Graph.G03_Topo;

import java.util.*;

public class G20_CourseScheduleII {
    public static void main(String[] args) {
        G20_CourseScheduleII solution = new G20_CourseScheduleII();

        // Test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[] result1 = solution.findOrder(numCourses1, prerequisites1);
        System.out.println("Test Case 1: " + Arrays.toString(result1)); // Expected: [0, 1]

        // Test case 2
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result2 = solution.findOrder(numCourses2, prerequisites2);
        System.out.println("Test Case 2: " + Arrays.toString(result2)); // Expected: [0, 1, 2, 3] or [0, 2, 1, 3]

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        int m = prerequisites.length;
        int n = prerequisites[0].length;
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> topo=new ArrayList<>();

        while (!queue.isEmpty()){
            int node=queue.poll();
            topo.add(node);

            for(int nbr: adjList.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    queue.add(nbr);
                }
            }
        }

        if(topo.size()==numCourses){
            return topo.stream().mapToInt(i->i).toArray();
        }else {
            return new int[0];
        }
    }
}

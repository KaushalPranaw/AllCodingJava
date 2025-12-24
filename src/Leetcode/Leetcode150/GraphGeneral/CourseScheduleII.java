package Leetcode.Leetcode150.GraphGeneral;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();

        // Test Case 1
        int numCourses1 = 4;
        int[][] prerequisites1 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] order1 = cs.findOrder(numCourses1, prerequisites1);
        System.out.println("Course Order (Test 1): " + Arrays.toString(order1));
        // Expected: [0,1,2,3] or [0,2,1,3]

        // Test Case 2 (cycle exists)
        int numCourses2 = 2;
        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };

        int[] order2 = cs.findOrder(numCourses2, prerequisites2);
        System.out.println("Course Order (Test 2): " + Arrays.toString(order2));
        // Expected: []
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < indegree.length; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return topo.stream().mapToInt(i -> i).toArray();
    }
}

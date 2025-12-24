package Leetcode.Leetcode150.GraphGeneral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        // Test Case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Can finish courses (Test 1): "
                + cs.canFinish(numCourses1, prerequisites1));
        // Expected: true

        // Test Case 2 (cycle exists)
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish courses (Test 2): "
                + cs.canFinish(numCourses2, prerequisites2));
        // Expected: false

        // Test Case 3
        int numCourses3 = 4;
        int[][] prerequisites3 = {
                {1, 0},
                {2, 1},
                {3, 2}
        };
        System.out.println("Can finish courses (Test 3): "
                + cs.canFinish(numCourses3, prerequisites3));
        // Expected: true
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);

            for (int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return list.size() == numCourses;
    }
}

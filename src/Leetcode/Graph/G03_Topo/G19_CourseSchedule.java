package Leetcode.Graph.G03_Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G19_CourseSchedule {
    public static void main(String[] args) {
        G19_CourseSchedule obj = new G19_CourseSchedule();

        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        boolean result = obj.canFinish(numCourses, prerequisites);
        if (result) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("It's not possible to finish all courses (cycle detected).");
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.poll();

            topo.add(node);

            for (int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        if (topo.size() == numCourses) {
            return true;
        } else {
            return false;
        }

    }
}

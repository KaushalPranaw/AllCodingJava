package Comp.CodeWithComplexity75.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C27_CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        C27_CourseSchedule o = new C27_CourseSchedule();
        System.out.println(o.canFinish(numCourses, prerequisites));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0])
                    .add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
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
            int node = queue.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }

        }
        if (topo.size() == numCourses) {
            return true;
        }
        return false;

    }
}

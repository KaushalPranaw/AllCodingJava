package Comp.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourse {
    //You’re given:
    //n total courses labeled from 1 to n.
    //An array relations[] where relations[i] = [a, b] means you must take course a before course b.
    //In each semester, you can take any number of courses as long as all prerequisites are met.
    public static void main(String[] args) {
        int n = 3;// Total 3 courses (1, 2, 3)
        int[][] relations = {{1, 3}, {2, 3}}; // Course 1 is needed before 3, and 2 before 3
        ParallelCourse obj = new ParallelCourse();
        int result = obj.minimumSemesters(n, relations);
        System.out.println("Minimum Semesters: " + result); // Expected: 2

    }

    public int minimumSemesters(int n, int[][] relations) {
        // Create a graph to represent courses and their dependencies
        List<List<Integer>> graph = new ArrayList<>();

        // Track how many prerequisites each course has
        int[] inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());// Initialize empty list for each course
        }

        for (int[] rel : relations) {
            int prev = rel[0], next = rel[1];
            graph.get(prev).add(next);// Add next course to prev's list
            inDegree[next]++;// Increment next course's prerequisite count
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);// Add courses with no prerequisites
            }
        }

        int semesters = 0;
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            semesters++; // Count this semester
            for (int i = 0; i < size; i++) {
                int course = queue.poll();
                coursesTaken++;

                for (int next : graph.get(course)) {
                    inDegree[next]--;// Reduce next course's prerequisite count
                    if (inDegree[next] == 0) {
                        queue.add(next);// If no more prerequisites, add to queue
                    }
                }
            }
        }
        return coursesTaken == n ? semesters : -1;
    }
}

package Comp.GSGR_PMW3;

import java.util.*;
import java.util.stream.Collectors;

public class Problem26_BestAvgGrade {
    public static void main(String[] args) {
        // Test Cases
        String[][] testCase1 = {
                {"Sarah", "91"},
                {"Goldie", "92"},
                {"Elaine", "93"},
                {"Elaine", "95"},
                {"Goldie", "94"},
                {"Sarah", "93"}
        };

        String[][] testCase2 = {
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}
        };

        String[][] testCase3 = {}; // Edge case: Empty input

        System.out.println(bestAverageGrade(testCase1)); // Output: 94
        System.out.println(bestAverageGrade(testCase2)); // Output: 87
        System.out.println(bestAverageGrade(testCase3)); // Output: 0
    }

    /*public static Integer bestAverageGrade(String[][] scores) {

        if (scores == null || scores.length == 0) {
            return 0;
        }
        // Map to store the sum of scores and count of scores for each student
        Map<String, List<Integer>> studentScores = new HashMap<>();

        // Populate the map with scores
        for (String[] scoreData : scores) {
            String student = scoreData[0];
            int score = Integer.parseInt(scoreData[1]);

            studentScores.putIfAbsent(student, new ArrayList<>()); // Initialize list if not present
            studentScores.get(student).add(score);                // Add score to student list
        }

        // Variable to track the best average grade
        int bestAverage = Integer.MIN_VALUE;

        // Calculate average and track the best average
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            List<Integer> scoresList = entry.getValue();
            int average = (int)Math.floor(scoresList.stream().mapToInt(Integer::intValue)
                    .average().orElse(0));

            // Update the best average
            bestAverage = Math.max(bestAverage, average);
        }

        return bestAverage;

    }*/
    public static Integer bestAverageGrade(String[][] scores) {
        if (scores == null || scores.length == 0) return 0;

        // Group scores by student name
        Map<String, List<Integer>> studentScores = Arrays.stream(scores)
                .collect(Collectors.groupingBy(
                        s -> s[0],
                        Collectors.mapping(s -> Integer.parseInt(s[1]), Collectors.toList())
                ));

        // Compute max average (floor) from the grouped scores
        return studentScores.entrySet().stream()
                .mapToInt(entry -> {
                    List<Integer> list = entry.getValue();
                    int sum = list.stream().mapToInt(Integer::intValue).sum();
                    return (int) Math.floor((double) sum / list.size());
                })
                .max()
                .orElse(0); // Return 0 if no scores exist

    }
}

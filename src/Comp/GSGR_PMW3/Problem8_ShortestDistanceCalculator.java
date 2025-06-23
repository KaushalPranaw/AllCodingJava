package Comp.GSGR_PMW3;

import java.util.ArrayList;
import java.util.List;

public class Problem8_ShortestDistanceCalculator {
    public static void main(String[] args) {
        // Test case
        String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
        System.out.println(shortestDistance(document, "is", "a")); // Output: 2.5
    }

    /*private static double shortestDistance(String document, String word1, String word2) {
        if (document == null || word1 == null || word2 == null) {
            throw new IllegalArgumentException("Document or words cannot be null");
        }

        // Convert everything to lowercase for case-insensitivity
        document = document.toLowerCase();
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        // Find all occurrences of word1 and word2 in the document
        List<Double> midpointsWord1 = findMidpoints(document, word1);
        List<Double> midpointsWord2 = findMidpoints(document, word2);

        // Calculate the shortest distance between midpoints
        double shortestDistance = Double.MAX_VALUE;

        for (double midpoint1 : midpointsWord1) {
            for (double midpoint2 : midpointsWord2) {
                shortestDistance = Math.min(shortestDistance, Math.abs(midpoint1 - midpoint2));
            }
        }

        return shortestDistance;


    }

    private static List<Double> findMidpoints(String document, String word) {
        List<Double> midpoints = new ArrayList<>();
        int index = 0;

        while ((index = document.indexOf(word, index)) != -1) {
            // Calculate the midpoint for this occurrence of the word
            double midpoint = index + word.length() / 2.0; // Use floating-point division
            midpoints.add(midpoint);
            index += word.length(); // Move index forward to find the next occurrence
        }

        return midpoints;
    }*/

    private static double shortestDistance(String document, String word1, String word2) {
        if (document == null || word1 == null || word2 == null) {
            throw new IllegalArgumentException("Document or words cannot be null");
        }

        document = document.toLowerCase();
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        List<Double> midPoints1 = findMidpoints(document, word1);
        List<Double> midPoints2 = findMidpoints(document, word2);

        double shortest = Integer.MAX_VALUE;
        for (Double mid1 : midPoints1) {
            for (Double mid2 : midPoints2) {
                shortest = Math.min(shortest, Math.abs(mid1 - mid2));
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;

    }

    private static List<Double> findMidpoints(String document, String word) {
        int index = 0;
        List<Double> midPoints = new ArrayList<>();
        while ((index = document.indexOf(word, index)) != -1) {
            double mid = index + ((double) word.length() / 2);
            midPoints.add(mid);
            index = index + word.length();
        }
        return midPoints;
    }
}

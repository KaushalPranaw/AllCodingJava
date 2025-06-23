package ProblemSolving.Misleneous;

import java.util.Arrays;
import java.util.Comparator;

public class LargestThreeDistinctElementsArray {
    public static void main(String[] args) {
        int arr[] = {10, 4, 3, 50, 23, 90};
        largestThreeDistinctElementsArray(arr);
    }

    private static void largestThreeDistinctElementsArray(int[] arr) {
        Arrays.stream(arr)
                .mapToObj(num -> (int) num)
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .distinct()
                .limit(3)
                .forEach(System.out::println);
    }
}

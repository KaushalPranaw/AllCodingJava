package ProblemSolving.Misleneous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class FindSecondLargestElementArray {
    public static void main(String[] args) {
        int arr[] = {10, 4, 3, 50, 90, 90};
        helper(arr);
    }

    private static void helper(int[] arr) {
        Optional<Integer> secondLar = Arrays.stream(arr)
                .mapToObj(num -> (int) num)
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .distinct()
                .skip(1)
                .findFirst();
        secondLar.ifPresent(System.out::println);
    }
}

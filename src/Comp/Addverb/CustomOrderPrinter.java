package Comp.Addverb;

import java.util.*;
import java.util.stream.Collectors;

public class CustomOrderPrinter {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 0, -1, 5, -2, 2, -4, 0, 1);

        List<Integer> result = numbers.stream()
                .sorted((a, b) -> {
                    if (a > 0 && b <= 0) return -1;       // positives before 0 or negatives
                    if (a <= 0 && b > 0) return 1;
                    if (a == 0 && b != 0) return -1;       // 0 after positives
                    if (a != 0 && b == 0) return 1;
                    return Integer.compare(Math.abs(a), Math.abs(b));  // sort positives & negatives separately
                })
                .collect(Collectors.toList());

        // Grouping to: positive sorted -> 0s -> negative sorted
        List<Integer> positives = numbers.stream()
                .filter(n -> n > 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> zeros = numbers.stream()
                .filter(n -> n == 0)
                .collect(Collectors.toList());

        List<Integer> negatives = numbers.stream()
                .filter(n -> n < 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> finalResult = new ArrayList<>();
        finalResult.addAll(positives);
        finalResult.addAll(zeros);
        finalResult.addAll(negatives);

        System.out.println("Custom order: " + finalResult);
        result.forEach(System.out::print);
    }
}

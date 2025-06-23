package Java8Practice.StreamsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        /*System.out.println("Stream without terminal operation");

        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        });

        System.out.println("Stream with terminal operation");
        Arrays.stream(new int[] { 1, 2, 3 }).map(i -> {
            System.out.println("doubling " + i);
            return i * 2;
        }).sum();*/


        List<Integer> input = Arrays.asList(10, 20, 30, 40);
        List<Double> output = new ArrayList<>();
        AtomicInteger sum = new AtomicInteger(0);

        input.stream()
                .forEach(n -> {
                    sum.addAndGet(n);
                    output.add(sum.doubleValue() / (output.size() + 1)); // Calculate and store running average
                });

        // Print the result
        output.forEach(avg -> System.out.print(avg + " "));
    }
}
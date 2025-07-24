package Comp.Addverb;

import java.util.*;

public class SmallestNumberFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, -5, 3, 0, 8, -2);
        System.out.println(numbers.stream().min(Comparator.comparingInt(n->n)).get());
    }
}

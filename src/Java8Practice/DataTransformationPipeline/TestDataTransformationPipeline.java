package Java8Practice.DataTransformationPipeline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
/*Create a system that processes a list of integers using a series of transformations (e.g., adding, multiplying, squaring) with `UnaryOperator`.

Requirements:
     - Create a list of integers.
     - Use `UnaryOperator<Integer>` to:
          - Add 10 to each integer.
          - Multiply each integer by 2.
          - Square each integer.
     - Chain the operators using `andThen()` to apply all transformations in a sequence.
     - Print the transformed list.

Add a mechanism to allow dynamic selection of transformations (e.g., via user input or configuration file).*/
public class TestDataTransformationPipeline {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 11, 24, 42, 12, 18));
        UnaryOperator<Integer> addUnaryOperator = (num) -> num + 10;
        UnaryOperator<Integer> multyUnaryOperator = (num) -> num * 2;
        UnaryOperator<Integer> squareUnaryOperator = (num) -> (int) Math.pow(num, 2);

        list.stream().map(addUnaryOperator.andThen(multyUnaryOperator).andThen(squareUnaryOperator))
                .forEach(System.out::println);

    }
}

package Java8Practice.PairwiseOperations;

import java.util.Scanner;
import java.util.function.BiFunction;

public class TestPairwiseOperations {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the first integer: ");
            int a = scanner.nextInt();

            System.out.println("Enter the second integer: ");
            int b = scanner.nextInt();

            System.out.println("Enter the operation (add/multiply): ");
            String operation = scanner.next();

            int result;
            if ("add".equalsIgnoreCase(operation)) {
                result = performOperation(a, b, add);
            } else if ("multiply".equalsIgnoreCase(operation)) {
                result = performOperation(a, b, multiply);
            } else {
                System.out.println("Invalid operation. Please choose 'add' or 'multiply'.");
                scanner.close();
                return;
            }

            System.out.println("The result of " + operation + " operation is: " + result);
        }


    }

    public static int performOperation(int a, int b, BiFunction<Integer, Integer, Integer> operation) {
        return operation.apply(a, b);
    }
}

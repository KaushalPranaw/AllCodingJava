package Java8Practice.ArithmeticOperations;

import java.util.function.BinaryOperator;
/*Create a program that performs arithmetic operations (addition, subtraction, multiplication, division) using `BinaryOperator`.

Requirements:
     - Define `BinaryOperator<Integer>` instances for each of the following operations:
          - Addition.
          - Subtraction.
          - Multiplication.
          - Division.
     - Create a method `performOperation()` that accepts two integers and a `BinaryOperator<Integer>`.
     - Use this method to perform all the arithmetic operations on the given numbers.

Handle division by zero and return a default value if an exception occurs during the operation.*/
public class TestArithmeticOperations {
    public static void main(String[] args) {
        BinaryOperator<Integer> addOperation = (num1, num2) -> num1 + num2;
        BinaryOperator<Integer> subOperation = (num1, num2) -> num1 - num2;
        BinaryOperator<Integer> mulOperation = (num1, num2) -> num1 * num2;
        BinaryOperator<Integer> divOperation = (num1, num2) -> {
            int num3 = 0;
            try {
                num3 = num1 / num2;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            return num3;
        };

        performOperation(2, 3, addOperation);
        performOperation(2, 3, subOperation);
        performOperation(2, 3, mulOperation);
        performOperation(2, 0, divOperation);
    }

    static void performOperation(int a, int b, BinaryOperator<Integer> operator) {
        System.out.println(operator.apply(a, b));
    }

}

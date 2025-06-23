package ProblemSolving.Stack;

import java.util.Stack;

public class EvaluatePostfixExpression {
    public static void main(String[] args) {
        String str = "100 200 + 2 / 5 * 7 +";
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                int n = 0;
                while (Character.isDigit(ch)) {
                    n = n * 10 + (ch - '0');
                    i++;
                    ch = str.charAt(i);
                }
                i--;
                numbers.push(n);
            } else {
                int num2 = numbers.pop();
                int num1 = numbers.pop();
                int result = solveOperator(num1, num2, ch);
                numbers.push(result);
            }
        }
        System.out.println(numbers.peek());
    }

    private static int solveOperator(int num1, int num2, char ch) {

        switch (ch) {
            case '+' -> {
                return num1 + num2;
            }
            case '-' -> {
                return num1 - num2;
            }
            case '*' -> {
                return num1 * num2;
            }
            case '/' -> {
                return num1 / num2;
            }

        }
        return 0;
    }
}

package Leetcode.Leetcode150.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                int result = 0;
                if (token.equals("+")) {
                    result += num1 + num2;
                } else if (token.equals("-")) {
                    result += num1 - num2;
                } else if (token.equals("*")) {
                    result += num1 * num2;
                } else if (token.equals("/")) {
                    result += num1 / num2;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

/*    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-/*".contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(switch (token) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> throw new IllegalStateException("not valid");

                });
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }*/

    /*public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (token.equals("+")) {
                    result += num1 + num2;
                } else if (token.equals("-")) {
                    result += num1 - num2;
                } else if (token.equals("*")) {
                    result += num1 * num2;
                } else if (token.equals("/")) {
                    result += num1 / num2;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());

    }

    boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }*/


}

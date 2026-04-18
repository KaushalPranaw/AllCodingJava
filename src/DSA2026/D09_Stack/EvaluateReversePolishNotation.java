package DSA2026.D09_Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        //Input: tokens = ["2","1","+","3","*"]
        //Output: 9
        //Explanation: ((2 + 1) * 3) = 9
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res;
                /*if (token.equals("+")) {
                    res = num1 + num2;
                } else if (token.equals("-")) {
                    res = num1 - num2;
                } else if (token.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                stack.push(res);*/
                switch (token) {
                    case "+": stack.push(num1 + num2); break;
                    case "-": stack.push(num1 - num2); break;
                    case "*": stack.push(num1 * num2); break;
                    case "/": stack.push(num1 / num2); break;
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();

    }

    private static boolean isOperator(String token) {
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }
}

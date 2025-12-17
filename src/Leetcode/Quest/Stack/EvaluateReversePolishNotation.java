package Leetcode.Quest.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        /*
        Input: tokens = ["4","13","5","/","+"]
        Output: 6
        Explanation: (4 + (13 / 5)) = 6
         */

    }

    public int evalRPN(String[] tokens) {
        //loop of tokens
        // push into stack
        //if coming special chars
        //take 2 elments out from stakc and cal and puhs again
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!specialChar(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res;
                if (token.equals("+")) {
                    res = num1 + num2;
                } else if (token.equals("-")) {
                    res = num1 - num2;
                } else if (token.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                stack.push(res);
            }
        }
        return stack.pop();

    }

    private boolean specialChar(String token) {
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("/") ||
                token.equals("*");
    }
}

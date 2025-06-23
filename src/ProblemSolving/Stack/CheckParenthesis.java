package ProblemSolving.Stack;

import java.util.Stack;

public class CheckParenthesis {
    public static void main(String[] args) {
        /*String s = "[()]{}{[()()]()}";*/
        String s = "[(])";
        System.out.println(checkParenthesis(s));
        /*
        2 3 1 * + 9 -
        2 3 + 9 -
        5 9 -
        -4
        */
    }

    private static boolean checkParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char last = stack.peek();
                    if ((ch == ')' && last == '(') || (ch == '}' && last == '{') || (ch == ']' && last == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

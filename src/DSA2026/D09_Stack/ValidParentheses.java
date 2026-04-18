package DSA2026.D09_Stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        //Input: s = "()[]{}"
        //
        //Output: true
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char last = stack.peek();
                    if ((last == '{' && c == '}') || (last == '[' && c == ']') || (last == '(' && c == ')')) {
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

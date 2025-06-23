package Leetcode.Auto.Premium;

public class ValidExpression {
    public static void main(String[] args) {
        // Test cases
        System.out.println(checkValidExpression("(*)"));  // Output: valid
        //System.out.println(checkValidExpression("((*()"));  // Output: invalid
    }
    public static String checkValidExpression(String s) {
        int min_open = 0;  // minimum open parentheses required
        int max_open = 0;  // maximum open parentheses we can have

        for (char c : s.toCharArray()) {
            if (c == '(') {
                min_open++;
                max_open++;
            } else if (c == ')') {
                min_open--;
                max_open--;
            } else if (c == '*') {
                min_open--;  // Treat '*' as ')'
                max_open++;  // Treat '*' as '('
            }

            // Ensure min_open is not negative (no excess closing parentheses)
            if (min_open < 0) {
                min_open = 0;
            }

            // If max_open goes negative, it's invalid
            if (max_open < 0) {
                return "invalid";
            }
        }

        // If min_open is 0, it means we have balanced parentheses
        return min_open == 0 ? "valid" : "invalid";
    }
}

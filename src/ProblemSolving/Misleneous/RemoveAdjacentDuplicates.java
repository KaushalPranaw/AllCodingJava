package ProblemSolving.Misleneous;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        // Test cases
        System.out.println(removeDuplicates("abcd", 2));  // Output: "abcd"
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));  // Output: "aa"
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));  // Output: "ps"
        System.out.println(removeDuplicates("aaabbbacd", 3));  // Output: "acd"
    }

    private static String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //If the stack is not empty and the top element matches the current character
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;// Increment the count
                // If the count reaches k, pop the character from the stack
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{c, 1});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] entry : stack) {
            for (int i = 0; i < entry[1]; i++) {
                sb.append((char) entry[0]);
            }
        }
        return sb.toString();
    }
}

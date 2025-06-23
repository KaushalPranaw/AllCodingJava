package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new GenerateParentheses().generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String cur, int open, int close, int n) {
        //base case

        // If the current string has reached the maximum length (n pairs)
        if (cur.length() == n*2) {
            list.add(cur);
            return;
        }

        // If we can add more opening parentheses
        if (open < n) {
            backtrack(list, cur + "(", open + 1, close, n);
        }
        // If we can add closing parentheses (must be less than opening ones)
        if (close < open) {
            backtrack(list, cur + ")", open, close + 1, n);
        }


    }
}

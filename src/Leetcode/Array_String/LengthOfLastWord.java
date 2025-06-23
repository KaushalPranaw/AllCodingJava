package Leetcode.Array_String;

import java.util.PriorityQueue;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                len++;
            } else {
                if (len > 0) {
                    return len;
                }
            }
        }
        return len;
    }
}

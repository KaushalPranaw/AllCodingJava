package Leetcode.Leetcode150.TwoPointers;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        //s = "abc", t = "ahbgdc"
        if (s.length() > t.length()) {
            return false;
        }
        if (s.isEmpty()) return true;
        int index = 0;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
                if (s.length() == index) {
                    return true;
                }
            }
        }
        return false;

    }
}

package Leetcode.Leetcode150.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(new IsomorphicStrings().isIsomorphic(s, t));

    }

    public boolean isIsomorphic(String s, String t) {
        //base case
        if (s.length() != t.length()) {
            return false;
        }

        int[] ascii1 = new int[256];
        int[] ascii2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (ascii1[s.charAt(i)] != ascii2[t.charAt(i)]) {
                return false;
            }
            ascii1[s.charAt(i)] = i + 1;
            ascii2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

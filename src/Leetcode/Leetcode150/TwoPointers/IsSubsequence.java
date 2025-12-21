package Leetcode.Leetcode150.TwoPointers;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        if (s.isEmpty()) {
            return true;
        }

        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            char tchar = t.charAt(i);
            if (tchar == s.charAt(index)) {
                index++;
            }
            if (s.length() == index) {
                return true;
            }
        }
        return false;
    }


    //better sol upar wala hai but we can do using dp also
    /*public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        return isSubsequenceHelper(m - 1, n - 1, m, n, s, t, dp);

    }

    private boolean isSubsequenceHelper(int i, int j, int m, int n, String s, String t, boolean[][] dp) {
        if (i == m) {
            return true;
        }

        if (j == n) {
            return false;
        }

        if (dp[i][j] != false) {
            return dp[i][j];
        }

        //match case
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = isSubsequenceHelper(i + 1, j + 1, m, n, s, t, dp);
        } else {
            return dp[i][j] = isSubsequenceHelper(i, j + 1, m, n, s, t, dp);
        }
    }*/
}

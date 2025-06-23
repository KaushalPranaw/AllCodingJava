package Leetcode.DP.DP03_Strings;

public class DP30_MinInsertions_DeletionstoConvertStringAtoStringB {
    public static void main(String[] args) {
        //first try to get common element
        //which is 'ac' using lcs
        //now delete remaining char from s1
        //abcd->bd->2 op
        //npw delete remaining char from s2
        //anc->n-> 1 op
        //total operation ->2+1=3
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                + canYouMake(str1, str2));
    }

    private static int canYouMake(String str1, String str2) {
        int len = lcs(str1, str2);

        int m = str1.length();
        int n = str2.length();
        //m-len -> means jo common element ni h in str1
        //n-len -> means jo common element ni h in str2

        return (m - len) + (n - len);
    }

    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


}

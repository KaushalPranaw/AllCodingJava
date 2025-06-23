package Leetcode.DP.DP03_Strings;

public class DP26_PrintLongestCommonSubsequence {
    public static void main(String args[]) {

        String s1 = "abcde";
        String s2 = "bdgek";

        System.out.print("The Longest Common Subsequence is ");
        System.out.println(lcs(s1, s2));
    }

    private static String lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        //initialize first row and first col
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //ans = dp[m][n];
        int len = dp[m][n];

        //since we have to print LCS
        //so first see dp table
//        for(int i=0;i<=m;i++){
//            for(int j=0;j<=n;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        //rule
        //start from right most
        //if s1[i-1]==s2[j-1] to hum list me le lege aur will do i--, j--
        //if s1[i-1]!=s2[j-1] to if(dp[i-1][j]>dp[i][j-1]) -> i-- else j--

        char[] ca = new char[len];
        int index = ca.length - 1;
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ca[index] = s1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return new String(ca);
    }
}

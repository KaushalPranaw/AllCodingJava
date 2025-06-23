package Leetcode.DP.DP03_Strings;

import java.util.Arrays;

public class DP33_EditDistance {
    public static void main(String args[]) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " +
                minDistance(s1, s2));
    }

    //recur+memo
    /*private static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return minDistanceUtil(m - 1, n - 1, s1, s2, dp);
    }

    private static int minDistanceUtil(int i, int j, String s1, String s2, int[][] dp) {
        //base case
        if (i < 0) {
            //mtlb s1 is null
            //s2 me jitne character hai utne add kr dege s1 me to dono barabar ho jayge
            return j + 1;// j==1 means j is at index 1 so total chars are 2
        }
        if (j < 0) {
            //mtlb s2 is null
            //s1 me jitne character hai utne delete kr dege to dono barabar ho jayge
            // no of operation needed i+1
            return i + 1;// i==1 means i is at index 1 so total chars are 2 jo delete kr dege
        }

        // memo check
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = minDistanceUtil(i - 1, j - 1, s1, s2, dp);
        } else {
            //case 1: insert
            //agar insert krege to i ho jayega i+1
            //aur j rhega j aur dono same ho jayege
            //to i+1-1, aur j-1=> i, j-1
            int insert = 1 + minDistanceUtil(i, j - 1, s1, s2, dp);

            //case 2: delete
            //agar delete krte h to i ->i-1
            int delete = 1 + minDistanceUtil(i - 1, j, s1, s2, dp);

            //case 3: replace
            //agar replace krte h to i-> i only aur dono same ho jayege
            int replace = 1 + minDistanceUtil(i - 1, j - 1, s1, s2, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

    }*/

    //tabulation
    /*private static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        //base case
//        if (i < 0) {
//            return j + 1;
//        }
//        if (j < 0) {
//            return i + 1;
//        }

        //i==0 then return j+2;
        //j==0 then return i+2;
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //case 1: insert
                    //agar insert krege to i ho jayega i+1
                    //aur j rhega j aur dono same ho jayege
                    //to i+1-1, aur j-1=> i, j-1
                    int insert = 1 + dp[i][j - 1];

                    //case 2: delete
                    //agar delete krte h to i ->i-1
                    int delete = 1 + dp[i - 1][j];

                    //case 3: replace
                    //agar replace krte h to i-> i only aur dono same ho jayege
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }*/

    //space
    private static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] prev = new int[n + 1];

        //base case
//        if (i < 0) {
//            return j + 1;
//        }
//        if (j < 0) {
//            return i + 1;
//        }

        //i==0 then return j+2;
        //j==0 then return i+2;
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    //case 1: insert
                    //agar insert krege to i ho jayega i+1
                    //aur j rhega j aur dono same ho jayege
                    //to i+1-1, aur j-1=> i, j-1
                    int insert = 1 + cur[j - 1];

                    //case 2: delete
                    //agar delete krte h to i ->i-1
                    int delete = 1 + prev[j];

                    //case 3: replace
                    //agar replace krte h to i-> i only aur dono same ho jayege
                    int replace = 1 + prev[j - 1];
                    cur[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = cur.clone();
        }
        return prev[n];

    }
}

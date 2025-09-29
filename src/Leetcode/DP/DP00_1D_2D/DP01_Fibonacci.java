package Leetcode.DP.DP00_1D_2D;

import java.util.Arrays;

public class DP01_Fibonacci {
    public static void main(String[] args) {

        int n = 6;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(n));
    }


    /*
     Time Complexity: O(N)

     Reason: The overlapping subproblems will return the answer in constant time O(1).
     Therefore the total number of new subproblems
     we solve is ‘n’. Hence total time complexity is O(N).

     Space Complexity: O(N)

     Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
     Therefore total space complexity will be O(N) + O(N) ≈ O(N)

 */
    //recur+memo
    /*private static int f(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if(dp[n]!=-1){
            //means already ans calculated
            return dp[n];
        }

        //means ans not calculated
        return dp[n]=f(n - 1, dp) + f(n - 2, dp);
    }*/

    //bottom up (tab)
    /*private static int f(int n) {
        //ulta
        //phle base cond of dp initialize krege
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        //now for other values
        for (int i = 2; i <= n; i++) {
            //copy paste
            //return dp[n]=f(n - 1, dp) + f(n - 2, dp);
            dp[i] = dp[n - 1] + dp[n - 2];
        }
        //return last value
        return dp[n];
    }*/

    //space optimize
    private static int f(int n) {
        //copy paste bottom up
        // check for for loop think
        //we got to know we need just 2 prev value
        //so instead of dp array we can take 2 variables
        /*int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;*/
        int prev2 = 0;
        int prev1 = 1;

        //now for other values
        for (int i = 2; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        //return last value
        return prev1;
    }
}

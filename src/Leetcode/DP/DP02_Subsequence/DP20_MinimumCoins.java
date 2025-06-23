package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

public class DP20_MinimumCoins {
    public static void main(String args[]) {
        int arr[] = {9, 5, 6, 1};
        int T = 11;

        // Call the minimumElements function and print the result
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElements(arr, T));
    }

    //recur+memo
    /*private static int minimumElements(int[] arr, int T) {
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumElementsUtil(n - 1, T, arr, dp);
    }

    private static int minimumElementsUtil(int ind, int T, int[] arr, int[][] dp) {
        //base case
        if (ind == 0) {
            if (T % arr[ind] == 0) {
                return T / arr[ind];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (dp[ind][T] != -1) {
            return dp[ind][T];
        }

        int not_take = minimumElementsUtil(ind - 1, T, arr, dp);
        int take = Integer.MAX_VALUE;
        if (T - arr[ind] >= 0) {
            int res = minimumElementsUtil(ind, T - arr[ind], arr, dp);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        return dp[ind][T] = Math.min(take, not_take);
    }*/

    //tabulation
    /*private static int minimumElements(int[] arr, int Total) {
        int n = arr.length;
        int[][] dp = new int[n][Total + 1];

        //base case
        for (int t = 0; t <= Total; t++) {
            if (t % arr[0] == 0) {
                dp[0][t] = t / arr[0];
            } else {
                dp[0][t] = Integer.MAX_VALUE;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int T = 0; T <= Total; T++) {
                int not_take = dp[ind - 1][T];
                int take = Integer.MAX_VALUE;
                if (T - arr[ind] >= 0) {
                    int res = dp[ind - 1][T - arr[ind]];
                    if (res != Integer.MAX_VALUE) {
                        take = 1 + res;
                    }
                }
                dp[ind][T] = Math.min(take, not_take);
            }
        }
        return dp[n - 1][Total];
    }*/

    //space optimize
    private static int minimumElements(int[] arr, int Total) {
        int n = arr.length;
        int[] prev = new int[Total + 1];

        //base case
        for (int t = 0; t <= Total; t++) {
            if (t % arr[0] == 0) {
                prev[t] = t / arr[0];
            } else {
                prev[t] = Integer.MAX_VALUE;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[Total + 1];
            for (int T = 0; T <= Total; T++) {
                int not_take = prev[T];
                int take = Integer.MAX_VALUE;
                if (T - arr[ind] >= 0) {
                    int res = prev[T - arr[ind]];
                    if (res != Integer.MAX_VALUE) {
                        take = 1 + res;
                    }
                }
                cur[T] = Math.min(take, not_take);
            }
            prev = cur.clone();
        }
        return prev[Total];
    }
}

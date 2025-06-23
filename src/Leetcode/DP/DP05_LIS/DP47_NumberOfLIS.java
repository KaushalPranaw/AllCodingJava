package Leetcode.DP.DP05_LIS;

import java.util.Arrays;

public class DP47_NumberOfLIS {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 6, 7, 2};

        System.out.println("The count of LIS is " + findNumberOfLIS(arr));
    }

    private static int findNumberOfLIS(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n];
        int[] ct = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(ct, 1);

        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    //inherit
                    ct[i] = ct[prev];
                } else if (arr[i] > arr[prev] && 1 + dp[prev] == dp[i]) {
                    //increase the count
                    ct[i] = ct[i] + ct[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                count += ct[i];
            }
        }
        return count;

    }
}

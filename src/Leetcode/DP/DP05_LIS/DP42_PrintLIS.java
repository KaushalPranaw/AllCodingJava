package Leetcode.DP.DP05_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP42_PrintLIS {
    public static void main(String[] args) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("longest increasing subsequence is");
        System.out.println(longestIncreasingSubsequence(arr, n));
    }
    /*private static int longestIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);//min len is one for LIS

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }*/


    //for printing LIS
    private static List<Integer> longestIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        //hash me hum prev index dal rhe h
        //taki trace kr paye
        //jo ki help krega LIS print krne me
        int lastIndex = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    //since prev is updated to hum hash ko b update kr rhe h
                    hash[i] = prev;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                lastIndex = i;
            }
        }
        //now we know the lastIndex
        //ab hum ulta trace krege with the help of hash array
        List<Integer> list = new ArrayList<>();
        list.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.add(arr[lastIndex]);
        }
        Collections.reverse(list);
        return list;
    }
}

package Leetcode.DP.DP05_LIS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DP45_LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        System.out.println("The length of the longest string chain is: " + longestStrChain(words));
    }

    private static int longestStrChain(String[] arr) {
        int n = arr.length;
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(arr[j], arr[i]) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
                maxi = Math.max(maxi, dp[i]);
            }
        }
        return maxi;
    }

    private static boolean isPredecessor(String shorter, String longer) {
        if (longer.length() - shorter.length() != 1) return false;

        for (int i = 0; i < longer.length(); i++) {
            String modified = longer.substring(0, i) + longer.substring(i + 1);
            if (modified.equals(shorter)) {
                return true;
            }
        }

        return false;
    }
}

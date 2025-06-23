package Leetcode.DP.DP05_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP44_LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};

        List<Integer> ans = divisibleSet(arr);

        System.out.print("The longest divisible subset elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    private static List<Integer> divisibleSet(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        int lastIndex = 0;
        int max = 1;

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans.add(arr[lastIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }
}

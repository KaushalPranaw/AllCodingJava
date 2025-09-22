package Leetcode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayEqualToK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 0, 1};
        int k = 3;
        System.out.println(longestSubArrayEqualsToK(arr, k));
    }

    private static int longestSubArrayEqualsToK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLen = i + 1;
            }

            if (prefixSumMap.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - prefixSumMap.get(prefixSum - k));
            }

            prefixSumMap.putIfAbsent(prefixSum, i);
        }

        return maxLen;

    }
}

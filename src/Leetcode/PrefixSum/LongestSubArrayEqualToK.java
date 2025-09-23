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

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLen = Math.max(maxLen, i + 1);//means first time we are getting
            }

            //now do reverse enginerring
            int rem = prefixSum - k;
            if (prefixSumMap.containsKey(rem)) {
                int len = i - prefixSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            //for handling negative num we need to check if not exist then we have to add
            if(!prefixSumMap.containsKey(prefixSum))
                prefixSumMap.put(prefixSum, i);
        }
        return maxLen;

    }
}

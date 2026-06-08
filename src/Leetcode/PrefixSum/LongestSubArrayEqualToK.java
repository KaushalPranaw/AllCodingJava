package Leetcode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayEqualToK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 0, 1};
        int k = 3;
        System.out.println(longestSubArrayEqualsToK(arr, k));
    }

    /*
    Count Subarrays Sum = K
    Map<PrefixSum, Count>

    Longest Subarray Sum = K
    Map<PrefixSum, FirstIndex>
    That's the biggest change.


     */
    /*private static int longestSubArrayEqualsToK(int[] nums, int k) {

        //map<prefixsum, firstIndex>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();


        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLen = Math.max(maxLen, i + 1);//means first time we are getting
            }

            //now do reverse enginerring
            int oldPrefix = prefixSum - k;
            if (prefixSumMap.containsKey(oldPrefix)) {
                int len = i - prefixSumMap.get(oldPrefix);
                maxLen = Math.max(maxLen, len);
            }
            //for handling negative num we need to check if not exist then we have to add
            //since we need sbse bada to jo sbse phle aya hoga wahi bada hoga
            //isiliye if not inserted then add
            if(!prefixSumMap.containsKey(prefixSum))
                prefixSumMap.put(prefixSum, i);
        }
        return maxLen;

    }*/
    private static int longestSubArrayEqualsToK(int[] nums, int k) {

        //map<prefixsum, firstIndex>
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            //coming first time sum equals k
            if (prefixSum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int oldPrefix = prefixSum - k;
            if (map.containsKey(oldPrefix)) {
                int len = i - map.get(oldPrefix);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;

    }
}

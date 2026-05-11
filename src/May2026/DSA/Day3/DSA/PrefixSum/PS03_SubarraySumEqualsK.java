package May2026.DSA.Day3.DSA.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class PS03_SubarraySumEqualsK {
    public static void main(String[] args) {
        //Example 1:
        //Input: nums = {1, 1, 1}, k = 2
        //Output: 2
        //Explanation: The subarrays that sum to 2 are: [1, 1] (starting at index 0) and [1, 1] (starting at index 1).
        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays that sum to " + k + ": " + result);
    }

    private static int subarraySum(int[] nums, int k) {

        //creating map to store prefix sum and its frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//prefix sum 0 has frequency 1

        int count = 0;
        int currentPrefixSum = 0;

        // We are looking for the number of subarrays that sum to k.
        // To find this, we can use the concept of prefix sums.
        //subarray sum from index i to j can be calculated as prefixSum[j] - prefixSum[i-1]
        //subarray sum=k => prefixSum[j] - prefixSum[i]
        //prefixSum[j] - k = prefixSum[i]
        //j-> current index while i-> previous index where prefix sum is prefixSum[i]
        //so we need to find how many times prefixSum[i] has occurred before the current index j, which is equivalent to finding how many times (currentPrefixSum - k) has occurred in the map.
        //formula: currentPrefixSum - k = previousPrefixSum
        //layman: current prefix sum - target k = previous prefix sum

        for (int num : nums) {
            currentPrefixSum += num;


            //old prefix sum is the prefix sum
            //that we need to find in the map to get the count of subarrays that sum to k
            int oldPrefixSum = currentPrefixSum - k;
            if (map.containsKey(oldPrefixSum)) {
                count += map.get(oldPrefixSum);
            }
            //update the count of current prefix sum in the map
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }
        return count;
    }
}

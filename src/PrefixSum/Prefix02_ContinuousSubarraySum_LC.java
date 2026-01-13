package PrefixSum;

import java.util.HashMap;
import java.util.Map;

/*
If the value stored in the map represents an INDEX → use -1
If the value stored represents a COUNT → use 1
 */
public class Prefix02_ContinuousSubarraySum_LC {
    public static void main(String[] args) {
        Prefix02_ContinuousSubarraySum_LC obj =
                new Prefix02_ContinuousSubarraySum_LC();

        // Example 1: Normal case
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println("Example 1 Result: "
                + obj.checkSubarraySum(nums1, k1)); // true

        // Example 2: Subarray starts from index 0
        int[] nums2 = {2, 4};
        int k2 = 6;
        System.out.println("Example 2 Result: "
                + obj.checkSubarraySum(nums2, k2)); // true

        // Example 3: k = 0 case
        int[] nums3 = {1, 0, 0};
        int k3 = 0;
        System.out.println("Example 3 Result: "
                + obj.checkSubarraySum(nums3, k3)); // true

        // Example 4: No valid subarray
        int[] nums4 = {1, 2, 3};
        int k4 = 5;
        System.out.println("Example 4 Result: "
                + obj.checkSubarraySum(nums4, k4)); // true
    }

    /*
    If

sum(i+1 → j) % k == 0
Then
(prefixSum[j] - prefixSum[i]) % k == 0
Which means:

prefixSum[j] % k == prefixSum[i] % k
Same remainder = valid subarray

Why are we storing remainder → index?
==========================
We want to remember:
“At which index did I FIRST see this remainder?”
*/

    public boolean checkSubarraySum(int[] nums, int k) {
        // Map: remainder -> first index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = (k == 0) ? prefixSum : (prefixSum % k);
            if (map.containsKey(remainder)) {
                //check subarray len >= 2 //asked in ques
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                //remainder coming first time
                map.put(remainder, i);
            }
        }
        return false;

    }
}

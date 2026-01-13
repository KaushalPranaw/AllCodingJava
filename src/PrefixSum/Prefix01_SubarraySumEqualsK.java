package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class Prefix01_SubarraySumEqualsK {
    public static void main(String[] args) {
        // ✅ Example 1: Positive numbers
        int[] nums1 = {1, 2, 3};
        int k1 = 3;
        int result1 = subarraySum(nums1, k1);
        System.out.println("Example 1 → Subarrays with sum " + k1 + ": " + result1);

        // ✅ Example 2: Includes negative numbers
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        int result2 = subarraySum(nums2, k2);
        System.out.println("Example 2 → Subarrays with sum " + k2 + ": " + result2);

        // ✅ Example 3: Mixed positive & negative
        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        int result3 = subarraySum(nums3, k3);
        System.out.println("Example 3 → Subarrays with sum " + k3 + ": " + result3);
    }

    /*
        Example:
        nums = [3, 4, 7, 2, -3, 1, 4, 2]
        k = 7

        Prefix Sum (pf):
        index :  0   1   2   3   4   5   6   7
        nums  :  3   4   7   2  -3   1   4   2
        pf    :  3   7  14  16  13  14  18  20

        Suppose index i+1 to j ka sum = k

        Subarray sum formula:
        pf(j) - pf(i) = k

        Rearrange:
        pf(j) - k = pf(i)

        Matlab:
        Agar current prefix sum pf(j) se k minus karne par
        koi previous prefix sum pf(i) exist karta hai,
        toh i+1 se j tak ek valid subarray mil gaya.

        -----------------------------------
        Dry Run:

        k = 7

        Start:
        starting me prefix sum 0 hai to put in map
        map = {0 = 1}   // base case
        sum = 0

        j = 0
        sum = 3
        sum - k = -4  ❌ (not in map)
        map = {0=1, 3=1}

        j = 1
        sum = 7
        sum - k = 0   ✅ (found in map)
        → subarray [0..1] = [3,4]
        map = {0=1, 3=1, 7=1}

        j = 2
        sum = 14
        sum - k = 7   ✅
        → subarray [2..2] = [7]
        map = {0=1, 3=1, 7=1, 14=1}

        j = 3
        sum = 16
        sum - k = 9   ❌
        map = {0=1, 3=1, 7=1, 14=1, 16=1}

        j = 4
        sum = 13
        sum - k = 6   ❌
        map = {..., 13=1}

        j = 5
        sum = 14
        sum - k = 7   ✅
        → subarray [3..5] = [2,-3,1]
        map = {..., 14=2}

        j = 6
        sum = 18
        sum - k = 11  ❌
        map = {..., 18=1}

        j = 7
        sum = 20
        sum - k = 13  ✅
        → subarray [5..7] = [1,4,2]

        -----------------------------------
        Final Answer = 4 subarrays
        -----------------------------------

        Conclusion:
        Hum har index j par check karte hain:
        pf(j) - k pehle kahin aaya hai ya nahi

        Agar aaya hai:
        → subarray exists
        → count increase

        Isliye ye approach negative numbers ke saath bhi kaam karti hai.
     */
    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);


        int sum = 0;//prefix sum batayega
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

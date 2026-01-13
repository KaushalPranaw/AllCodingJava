package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class Prefix03_MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(maxSubArrayLen(nums, k)); // 4
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // store first occurrence only
            map.putIfAbsent(prefixSum, i);

            if (map.containsKey(prefixSum - k)) {
                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}

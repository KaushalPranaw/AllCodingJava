package Leetcode.TUF.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class PS03_SubarraysDivByK {
    public static void main(String[] args) {

        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(new PS03_SubarraysDivByK().subarraysDivByK(nums, k));
    }

    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        //remainder → how many times this remainder occurred
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int remainder = prefixSum % k;
            // handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}

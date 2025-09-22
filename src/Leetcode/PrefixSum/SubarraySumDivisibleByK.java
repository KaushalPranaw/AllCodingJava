package Leetcode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {

        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(new SubarraySumDivisibleByK().subarraysDivByK(nums, k));

    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1);

        int prefixSum = 0, count = 0;
        for (int num : nums) {
            prefixSum += num;

            int rem = ((prefixSum % k) + k) % k;// handle negative remainders
            count += remainderMap.getOrDefault(rem, 0);
            remainderMap.put(rem, remainderMap.getOrDefault(rem, 0) + 1);
        }

        return count;


    }
}

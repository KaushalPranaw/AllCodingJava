package Leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array nums and an integer k, return true
    if there are two distinct indices i and j in the array
    such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1}, k = 3;
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int diff = Math.abs(map.get(i) - i);
                if (diff <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;

    }
}

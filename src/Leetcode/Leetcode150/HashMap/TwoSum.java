package Leetcode.Leetcode150.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {1, 2, 7, 11, 15}, target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                if (map.get(rem) == i) {
                    continue;
                } else {
                    return new int[]{i, map.get(rem)};
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}

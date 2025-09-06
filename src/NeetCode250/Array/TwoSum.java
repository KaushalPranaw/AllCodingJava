package NeetCode250.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15}, target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            if (map.containsKey(second)) {
                if (map.get(second) == i) {
                    continue;
                } else {
                    return new int[]{map.get(second), i};
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}

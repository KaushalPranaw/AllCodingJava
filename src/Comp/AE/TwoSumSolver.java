package Comp.AE;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSolver {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(findTwoSum(nums, 9)));
    }

    private static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{i, map.get(rem)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

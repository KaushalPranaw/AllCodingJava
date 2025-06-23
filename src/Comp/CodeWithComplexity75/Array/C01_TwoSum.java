package Comp.CodeWithComplexity75.Array;

import java.util.Arrays;
import java.util.HashMap;

public class C01_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new C01_TwoSum().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (map.containsKey(secondNumber)) {
                if (map.get(secondNumber) == i) {
                    continue;
                }
                return new int[]{map.get(secondNumber), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];

    }
}

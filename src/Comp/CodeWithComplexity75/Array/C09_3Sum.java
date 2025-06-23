package Comp.CodeWithComplexity75.Array;

import java.util.*;

public class C09_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new C09_3Sum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            //a+b=-c
            int target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    set.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}

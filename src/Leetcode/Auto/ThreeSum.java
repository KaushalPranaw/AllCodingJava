package Leetcode.Auto;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //a+b+c=0;
        //a+b=-c;
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            int target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    set.add(List.of(nums[i], nums[l], nums[r]));
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

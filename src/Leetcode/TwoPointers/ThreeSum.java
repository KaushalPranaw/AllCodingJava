package Leetcode.TwoPointers;

import CoreJava.OOPS.pillars.inheritance.A;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //a+b+c=0
        //a+b=-c;
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //a+b=-c;
        Arrays.sort(nums);
        Set<List<Integer>> wrap = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    wrap.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(wrap);

    }
}

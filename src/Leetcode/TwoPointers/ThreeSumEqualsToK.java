package Leetcode.TwoPointers;

import java.util.*;

public class ThreeSumEqualsToK {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //a+b+c=0
        //a+b=-c;
        int k = 2;
        System.out.println(new ThreeSumEqualsToK().threeSum(nums, k));
    }

    public List<List<Integer>> threeSum(int[] nums, int k) {
        //a+b=k-c
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int target = k - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    set.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else {
                    if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return new ArrayList<>(set);

    }
}

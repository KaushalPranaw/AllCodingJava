package Leetcode.SlidingWindow;

import java.util.Map;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7, nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                sum -= nums[l];
                l++;
            }
            r++;
            min = Math.min(min, r - l + 1);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

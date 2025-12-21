package Leetcode.Leetcode150.SlidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7, nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(min, (r - l + 1));
                sum -= nums[l++];
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

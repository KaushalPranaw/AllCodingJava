package DSA2026.D05_SlidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        //Input: target = 7, nums = [2,3,1,2,4,3]
        //Output: 2 -> [4,3]
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}

package Comp.AE;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("Maximum sum of subarray: " + result);
    }

    private static int maxSubArray(int[] nums) {
        /*int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            max = Math.max(max, curSum);
        }
        return max;*/

        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}

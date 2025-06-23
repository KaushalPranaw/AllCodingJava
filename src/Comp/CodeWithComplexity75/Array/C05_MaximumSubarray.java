package Comp.CodeWithComplexity75.Array;

public class C05_MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new C05_MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        int sum = 0;
        int maxSubArraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSubArraySum = Math.max(maxSubArraySum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSubArraySum;
    }
}

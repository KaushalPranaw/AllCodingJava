package Leetcode.Leetcode150.KadaneAlgorithm;

import java.util.Arrays;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        //Steps to Solve
        //Find the maximum subarray sum using Kadane’s Algorithm.
        //Find the minimum subarray sum using Kadane’s Algorithm (on -nums).
        //Calculate the circular max sum as totalSum - minKadane.
        //If all elements are negative, return the max subarray sum (ignoring circular sum).

        int maxKadane = kadane(nums);

        int totalSum = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        int minKadane = kadane(nums);

        int circularMax = totalSum - minKadane;

        if (circularMax == 0) {
            return maxKadane;
        }
        return Math.max(circularMax, maxKadane);

    }

    private int kadane(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
        /*int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;*/
    }
}

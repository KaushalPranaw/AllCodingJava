package Leetcode.KadaneAlgorithm;

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
        //Calculate the circular max sum as total sum - min sum.
        //If all elements are negative, return the max subarray sum (ignoring circular sum).

        int maxKadane = kadane(nums);

        int totalSum = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }

        int minKadane = kadane(nums);

        int maxCircular = totalSum + minKadane;

        if (maxCircular == 0) {
            return maxKadane;
        }
        return Math.max(maxKadane, maxCircular);

    }

    private int kadane(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}

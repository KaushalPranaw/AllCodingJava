package Leetcode.Leetcode150.TwoPointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        //Two Sum II - Input Array Is Sorted
        int numbers[] = {1, 2, 7, 11, 15}, target = 9;
        System.out.println(Arrays.toString(new TwoSumII().twoSum(numbers, target)));

    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}

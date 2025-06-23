package Leetcode.TwoPointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        //Two Sum II - Input Array Is Sorted
        int numbers[] = {1, 2, 7, 11, 15}, target = 9;
        System.out.println(Arrays.toString(new TwoSumII().twoSum(numbers, target)));

    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }
}

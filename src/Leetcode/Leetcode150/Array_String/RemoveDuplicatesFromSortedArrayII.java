package Leetcode.Leetcode150.Array_String;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            if (unique < 2 || num > nums[unique - 2]) {
                nums[unique++] = num;
            }
        }
        return unique;
    }
}

package Leetcode.Leetcode150.Array_String;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 2, 3, 0, 4, 2}, val = 2;
        System.out.println(new RemoveElement().removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}

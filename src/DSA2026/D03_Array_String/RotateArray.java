package DSA2026.D03_Array_String;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (nums == null || k == 0 || nums.length == 1) {
            return;
        }
        int n = nums.length;
        //rotate n-1
        reverse(nums, 0, n - 1);
        //rotate k-1
        reverse(nums, 0, k - 1);
        //rotate k to n-1
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}

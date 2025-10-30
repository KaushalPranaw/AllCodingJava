package Leetcode.Leetcode150.Array_String;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7}, k = 3;
        //[5,6,7,1,2,3,4]
        System.out.println(Arrays.toString(nums));
        new RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0 || n == 1) {
            return;
        }

        //1, 2, 3, 4, 5, 6, 7
        reverseArrary(nums, 0, n - 1);
        //7,6,5,4,3,2,1
        reverseArrary(nums, 0, k - 1);
        //5,6,7,4,3,2,1
        reverseArrary(nums, k, n - 1);
        //5,6,7,1,2,3,4
    }

    private void reverseArrary(int[] nums, int i, int j) {
        while (i <= j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}

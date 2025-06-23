package Leetcode.Auto.Premium;

import java.util.Arrays;

public class DistributeElementsIntoTwoArraysI {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5};
        int[] result = resultArray(nums);
        System.out.println(Arrays.toString(result));  // Output: [3, 4, 5, 1, 2]
    }

    public static int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int index1 = 0, index2 = 0;

        arr1[index1++] = nums[0];
        arr2[index2++] = nums[1];
        for (int i = 2; i < n; i++) {
            if (arr1[index1 - 1] > arr2[index2 - 1]) {
                arr1[index1++] = nums[i];
            } else {
                arr2[index2++] = nums[i];
            }
        }

        int res[] = new int[n];
        int resultIndex = 0;
        for (int i = 0; i < index1; i++) {
            res[resultIndex++] = arr1[i];
        }

        for (int i = 0; i < index2; i++) {
            res[resultIndex++] = arr2[i];
        }
        return res;
    }
}

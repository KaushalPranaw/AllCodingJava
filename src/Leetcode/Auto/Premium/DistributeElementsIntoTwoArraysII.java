package Leetcode.Auto.Premium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistributeElementsIntoTwoArraysII {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5};
        int[] result = resultArray(nums);
        System.out.println(Arrays.toString(result));  // Output: [3, 4, 5, 1, 2]
    }

    public static int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // Step 1: Append first element to arr1, second to arr2
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Iterate through nums from index 2 to n-1
        for (int i = 2; i < n; i++) {
            int num = nums[i];

            // Count elements greater than num in both arrays
            int count1 = greaterCount(arr1, num);
            int count2 = greaterCount(arr2, num);

            if (count1 > count2) {
                arr1.add(num);
            } else if (count1 < count2) {
                arr2.add(num);
            } else {
                // If counts are equal, append to the smaller array
                if (arr1.size() < arr2.size()) {
                    arr1.add(num);
                } else {
                    arr2.add(num);
                }
            }
        }
        // Merge arr1 and arr2 to get the final result
        List<Integer> result = new ArrayList<>(arr1);
        result.addAll(arr2);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int greaterCount(List<Integer> arr, int val) {
        int count = 0;
        for (int num : arr) {
            if (num > val) {
                count++;
            }
        }
        return count;
    }
}

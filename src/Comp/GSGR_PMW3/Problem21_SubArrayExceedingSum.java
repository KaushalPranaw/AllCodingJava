package Comp.GSGR_PMW3;

public class Problem21_SubArrayExceedingSum {
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 2, 3, 4};
        int target1 = 6;
        System.out.println(subArrayExceedsSum(arr1, target1)); // Output: 2

        int[] arr2 = {1, 2, 3, 4};
        int target2 = 1;
        System.out.println(subArrayExceedsSum(arr2, target2)); // Output: 1

        int[] arr3 = {1, 1, 1, 1, 1};
        int target3 = 5;
        System.out.println(subArrayExceedsSum(arr3, target3)); // Output: 5 (entire array)

        int[] arr4 = {1, 2, 3};
        int target4 = 6;
        System.out.println(subArrayExceedsSum(arr4, target4)); // Output: 3 (entire array)

        int[] arr5 = {1, 2, 3};
        int target5 = 10;
        System.out.println(subArrayExceedsSum(arr5, target5)); // Output: -1 (no valid subarray)
    }

    /*public static int subArrayExceedsSum(int[] arr, int target) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE; // Store the length of the shortest valid subarray
        int currentSum = 0; // Sum of the current window
        int start = 0; // Left pointer of the window

        // Iterate through the array
        for (int end = 0; end < n; end++) {
            // Add the current element to the window sum
            currentSum += arr[end];

            // Shrink the window from the left while the sum >= target
            while (currentSum >= target) {
                // Update the minimum length of the subarray
                minLength = Math.min(minLength, end - start + 1);

                // Shrink the window by removing the leftmost element
                currentSum -= arr[start];
                start++;
            }

        }

        // If no valid subarray is found, return -1
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }*/

    public static int subArrayExceedsSum(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0, r = 0;

        for (r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= arr[l];
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

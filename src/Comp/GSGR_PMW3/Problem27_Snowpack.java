package Comp.GSGR_PMW3;

public class Problem27_Snowpack {
    public static void main(String[] args) {
        // Test Case 1
        Integer[] arr1 = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        System.out.println(computeSnowpack(arr1));  // Output: 13

        // Test Case 2
        Integer[] arr2 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(computeSnowpack(arr2));  // Output: 10

        // Test Case 3
        Integer[] arr3 = {4, 2, 0, 3, 2, 5};
        System.out.println(computeSnowpack(arr3));  // Output: 9

        // Edge Case (Empty array)
        Integer[] arr4 = {};
        System.out.println(computeSnowpack(arr4));  // Output: 0

        // Edge Case (Flat terrain)
        Integer[] arr5 = {0, 0, 0, 0};
        System.out.println(computeSnowpack(arr5));  // Output: 0
    }

    public static Integer computeSnowpack(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // No elevations present.
        }

        int l = 0, r = arr.length - 1;
        int lMax = arr[l], rMax = arr[r];
        int trap = 0;
        while (l < r) {
            if (arr[l] < arr[r]) {
                lMax = Math.max(lMax, arr[l]);
                trap += Math.max(0, lMax - arr[l]);
                l++;
            } else {
                rMax = Math.max(rMax, arr[r]);
                trap += Math.max(0, rMax - arr[r]);
                r--;
            }
        }
        return trap;

    }

    /*public static Integer computeSnowpack(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // No elevations present.
        }

        int left = 0, right = arr.length - 1;
        int leftMax = arr[left], rightMax = arr[right];
        int snowpack = 0;

        while (left < right) {
            if (arr[left] < arr[right]) {
                leftMax = Math.max(leftMax, arr[left]);
                snowpack += Math.max(0, leftMax - arr[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, arr[right]);
                snowpack += Math.max(0, rightMax - arr[right]);
                right--;
            }
        }
        return snowpack;
    }*/

    /*public static Integer computeSnowpack(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // No elevations present.
        }

        int n = arr.length;
        int[] leftMax = new int[n];  // Array to store the maximum elevation to the left of each index
        int[] rightMax = new int[n]; // Array to store the maximum elevation to the right of each index


        // Compute left maximums:
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Compute right maximums:
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate the snowpack:
        int snowpack = 0;
        for (int i = 0; i < n; i++) {
            // Water level = min(left_max, right_max) - elevation
            int waterLevel = Math.min(leftMax[i], rightMax[i]) - arr[i];
            if (waterLevel > 0) {
                snowpack += waterLevel; // Accumulate the total snowpack
            }
        }

        return snowpack;
    }*/


}

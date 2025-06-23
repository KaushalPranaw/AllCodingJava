package Comp.google;

import java.util.Arrays;

public class LongestIncreasingSubarrayWithOneChange {
    public static void main(String[] args) {
        int[] arr1 = {7, 2, 3, 1, 5, 10};
        System.out.println(longestIncreasingSubarrayWithOneChange(arr1)); // Output: 5

        /*int[] arr2 = {10, 10};
        System.out.println(longestIncreasingSubarrayWithOneChange(arr2)); // Output: 2*/
    }

    private static int longestIncreasingSubarrayWithOneChange(int[] arr) {
        int n = arr.length;
        if (n <= 2) {
            return n;
        }

        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        dec[n - 1] = 1;

        // Fill inc[] - length of increasing subarray ending at i
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        System.out.println(Arrays.toString(inc));

        // Fill dec[] - length of increasing subarray starting at i
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }
        System.out.println(Arrays.toString(dec));

        int maxLen = Math.max(inc[n - 1], dec[0]); // initial max

        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] < arr[i + 1]) {
                maxLen = Math.max(maxLen, inc[i - 1] + 1 + dec[i + 1]);
            } else {
                maxLen = Math.max(maxLen, Math.max(inc[i - 1], dec[i + 1]) + 1);
            }
        }

        return maxLen;
    }
}

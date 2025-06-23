package Comp.GSGR_PMW3;

public class Problem17_SmallestNum {
    public static void main(String[] args) {
        System.out.println(FindMin(new int[]{3, 4, 5, 6, 1, 2}));  // Output: 1
        System.out.println(FindMin(new int[]{2, 1}));               // Output: 1
        System.out.println(FindMin(new int[]{1, 2, 3, 4, 5}));      // Output: 1
        System.out.println(FindMin(new int[]{6, 7, 8, 9, 10, 11, 1, 2, 3, 4})); // Output: 1
    }

    /*private static int FindMin(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int left = 0;
        int right = a.length - 1;

        // If array is not rotated at all
        if (a[left] < a[right]) {
            return a[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > a[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }
        return a[left];

    }*/

    private static int FindMin(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int l = 0, r = a.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > a[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return a[l];

    }
}

package Comp.GSGR_PMW3;

public class Problem20_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2)); // Output: 2.5

        int[] arr3 = {1, 3};
        int[] arr4 = {2};
        System.out.println(findMedianSortedArrays(arr3, arr4)); // Output: 2.0
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        if (n1 > n2) {
            return findMedianSortedArrays(B, A);
        }

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;

        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + (high - low) / 2);
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) r1 = A[mid1];
            if (mid2 < n2) r2 = B[mid2];

            if (mid1 - 1 >= 0) l1 = A[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = B[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                //odd case
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                }

                //even case
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;

    }

    /*public static double findMedianSortedArrays(int[] A, int[] B) {
        int[] merged = mergeArrays(A, B);
        int n = merged.length;
        if (n % 2 == 1) {
            return merged[n / 2];
        } else {
            return (double) (merged[(n - 1) / 2] + merged[n / 2]) / 2;
        }
    }

    private static int[] mergeArrays(int[] A, int[] B) {
        int[] merged = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                merged[k++] = A[i++];
            } else {
                merged[k++] = B[j++];
            }
        }

        while (i < A.length) {
            merged[k++] = A[i++];
        }

        while (j < B.length) {
            merged[k++] = B[j++];
        }

        return merged;
    }*/

}

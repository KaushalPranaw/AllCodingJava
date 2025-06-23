package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS08_SearchElementInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2, 3};
        int k = 0;
        System.out.println(searchRotated(arr, k));
    }

    private static int searchRotated(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == k) {
                return m;
            }
            if (arr[l] <= arr[m]) {
                if (arr[l] <= k && k <= arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (arr[m] <= k && k <= arr[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

}

package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS09_SearchElementInRotatedSortedArrayII {
    public static void main(String[] args) {
        int arr[] = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        System.out.println(searchRotated(arr, k));
    }

    private static boolean searchRotated(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == k) {
                return true;
            }
            // Handle duplicates: when we cannot determine the sorted half
            if (arr[l] == arr[m] && arr[m] == arr[r]) {
                l++;
                r--;
            }
            // Left half is sorted
            if (arr[l] <= arr[m]) {
                if (arr[l] <= k && k <= arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            // Right half is sorted
            else {
                if (arr[m] <= k && k <= arr[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }

}

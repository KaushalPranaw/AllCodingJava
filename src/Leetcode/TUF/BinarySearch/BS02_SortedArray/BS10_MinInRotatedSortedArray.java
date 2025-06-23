package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS10_MinInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {7, 8, 1, 2, 3, 4, 5, 6};
        int k = 3;
        System.out.println(searchRotated(arr, k));
    }

    private static int searchRotated(int[] arr, int k) {
        int ans = Integer.MAX_VALUE;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[l] < arr[r]) {
                ans = Math.min(ans, arr[l]);
                break;
            }

            if (arr[l] <= arr[m]) {
                ans = Math.min(ans, arr[l]);
                l = m + 1;
            } else {
                ans = Math.min(ans, arr[m]);
                r = m - 1;
            }
        }
        return ans;
    }
}

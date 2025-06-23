package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS11_FindKRotation {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findKRotation(arr);
        System.out.println("The array is rotated " + ans + " times.");
    }

    private static int findKRotation(int[] arr) {
        int index = -1;
        int ans = Integer.MAX_VALUE;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[l] <= arr[r]) {
                if (arr[l] < ans) {
                    index = l;
                    ans = arr[l];
                }
                break;
            }

            if (arr[l] <= arr[m]) {
                if (arr[l] < ans) {
                    index = l;
                    ans = arr[l];
                }
                l = m + 1;
            } else {
                if (arr[m] < ans) {
                    index = m;
                    ans = arr[m];
                }
                r = m - 1;
            }
        }
        return index;
    }

    /*private static int findKRotation(int[] arr) {
        int index = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            //finding minimum here
            if (arr[i] < ans) {
                ans = arr[i];
                index = i;
            }
        }
        return index;
    }*/

}

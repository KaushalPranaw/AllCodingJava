package Leetcode.TUF.BinarySearch;

public class BS03_ImplementUpperBound {
    public static void main(String[] args) {
        /*int arr[] = {1, 2, 2, 3};
        int x = 2;*/
        int arr[] = {3, 5, 8, 9, 15, 19};
        int x = 9;
        int ind = upperBound(arr, x);
        System.out.println("The upper bound is the index: " + ind);
        //arr[num]>x
    }

    private static int upperBound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > x) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}

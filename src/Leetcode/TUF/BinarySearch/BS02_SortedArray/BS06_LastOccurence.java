package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS06_LastOccurence {
    public static void main(String[] args) {
        int n = 7;
        int key = 13;
        int[] v = {3, 4, 13, 13, 13, 20, 40};

        // returning the last occurrence index if the element is present otherwise -1
        System.out.println(solve(n, key, v));
    }

    private static int solve(int n, int key, int[] arr) {
        int ans = -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) {
                ans = m;
                //since we need last occurence
                //so check aage ke elements also
                l = m + 1;
            } else if (arr[m] > key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}

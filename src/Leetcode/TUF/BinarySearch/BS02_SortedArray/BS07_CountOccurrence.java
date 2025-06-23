package Leetcode.TUF.BinarySearch.BS02_SortedArray;

public class BS07_CountOccurrence {
    public static void main(String[] args) {
        int n = 7;
        int key = 13;
        int[] v = {3, 4, 13, 13, 13, 13, 20, 40};

        System.out.println(countOccur(n, key, v));
    }

    private static int countOccur(int n, int key, int[] arr) {
        //Total number of occurrences = last occurrence - first occurrence + 1
        int first = firstOccur(n, key, arr);
        int last = lastOccur(n, key, arr);
        return last - first + 1;
    }

    private static int lastOccur(int n, int key, int[] arr) {
        int l = 0, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) {
                ans = m;
                //but uske aage b dekh lo agar ho to
                l = m + 1;
            } else if (arr[m] > key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private static int firstOccur(int n, int key, int[] arr) {
        int l = 0, r = n - 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) {
                ans = m;
                //but uske phle b dekh lo agar ho to
                r = m - 1;
            } else if (arr[m] > key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}

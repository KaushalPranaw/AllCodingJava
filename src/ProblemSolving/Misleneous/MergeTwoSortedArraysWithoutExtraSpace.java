package ProblemSolving.Misleneous;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int a[] = {2, 4, 7, 10, 0, 0}, b[] = {2, 3};
        int m = 4, n = 2;
        mergeArray(a, b, m, n);
        System.out.println(Arrays.toString(a));

    }

    private static void mergeArray(int[] a, int[] b, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k] = a[i];
                i--;
            } else {
                a[k] = b[j];
                j--;
            }
            k--;
        }
        while (i >= 0) {
            a[k] = a[i];
            i--;
            k--;
        }
        while (j >= 0) {
            a[k] = b[j];
            j--;
            k--;
        }
    }
}

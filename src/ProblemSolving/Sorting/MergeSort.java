package ProblemSolving.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        applyMergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void applyMergeSort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge1(arr, l, m, r);
        }
    }

    private static void merge1(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + l];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[i + m + 1];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }


}

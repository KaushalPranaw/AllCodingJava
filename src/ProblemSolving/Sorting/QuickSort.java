package ProblemSolving.Sorting;

import java.io.Serializable;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        applyQuickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void applyQuickSort(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        quickSort(arr, l, r);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {

        int pivot = arr[r];

        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

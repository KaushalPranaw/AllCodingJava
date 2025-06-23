package ProblemSolving.Sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        applyHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void applyHeapSort(int[] arr) {
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        //build the heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //one by one extract element from heap
        for (int i = n - 1; i >= 0; i--) {
            //replace root with last node
            swap(arr, i, 0);

            //again heapify for reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;

        //left tree node
        int l = 2 * i + 1;
        //right tree node
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than root
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, largest, i);
            //recursively call heapify
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}

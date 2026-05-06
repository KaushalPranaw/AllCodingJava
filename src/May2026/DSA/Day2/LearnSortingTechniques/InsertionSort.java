package May2026.DSA.Day2.LearnSortingTechniques;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        //Input: N = 5, array[] = {5,4,3,2,1}
        //Output: 1,2,3,4,5
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    🔹 Pass 1 (i = 1)

    Key = 4
    Compare with left:

    5 > 4 → shift 5 right
    Insert 4
    [4, 5, 3, 2, 1]

    👉 Sorted part: [4, 5]

    🔹 Pass 2 (i = 2)

    Key = 3

    5 > 3 → shift
    4 > 3 → shift
    Insert 3
    [3, 4, 5, 2, 1]

    👉 Sorted part: [3, 4, 5]

    🔹 Pass 3 (i = 3)

    Key = 2

    5 > 2 → shift
    4 > 2 → shift
    3 > 2 → shift
    Insert 2
    [2, 3, 4, 5, 1]

    👉 Sorted part: [2, 3, 4, 5]

    🔹 Pass 4 (i = 4)

    Key = 1

    5, 4, 3, 2 > 1 → shift all
    Insert 1
    [1, 2, 3, 4, 5]

    👉 Sorted 🎉

    📊 Visualization (Most Important)
    Initial:   [5, 4, 3, 2, 1]

    Pass 1:    [4, 5 | 3, 2, 1]
               ↑ sorted

    Pass 2:    [3, 4, 5 | 2, 1]
               ↑ sorted

    Pass 3:    [2, 3, 4, 5 | 1]
               ↑ sorted

    Pass 4:    [1, 2, 3, 4, 5]
               ↑ sorted

👉 Left side is always sorted
     */
    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

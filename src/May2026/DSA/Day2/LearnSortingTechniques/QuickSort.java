package May2026.DSA.Day2.LearnSortingTechniques;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //Input: N = 5, array[] = {5,4,3,2,1}
        //Output: 1,2,3,4,5
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        int low = 0, high = arr.length - 1;
        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    /*
🧪 Input
[5, 4, 3, 2, 1]
🔁 Step 1: Choose Pivot

Let’s pick last element as pivot (common approach)

👉 Pivot = 1

🔁 Partition (Core Step)

Goal: place pivot in correct position

Initial:
[5, 4, 3, 2, 1]
             ↑ pivot

We rearrange so:

[ < pivot | pivot | > pivot ]
🔹 Partition Result

Since all elements > 1:

[1, 4, 3, 2, 5]
 ↑
pivot index = 0
🔁 Recursion

Now solve left & right:

Left  = []
Right = [4, 3, 2, 5]
🔹 Next Pivot = 5
[4, 3, 2, 5]
          ↑ pivot

All elements < 5:

[4, 3, 2, 5]
             ↑ pivot fixed
🔹 Next Pivot = 2
[4, 3, 2]
       ↑ pivot

Partition:

[2, 3, 4]
 ↑ pivot fixed
🔹 Final
[1, 2, 3, 4, 5]
📊 Visualization (Full Flow)
Initial:   [5, 4, 3, 2, 1]

Pivot=1 →  [1 | 4, 3, 2, 5]

                [4, 3, 2, 5]
                Pivot=5
                [4, 3, 2 | 5]

                        [4, 3, 2]
                        Pivot=2
                        [2 | 3, 4]

Final:     [1, 2, 3, 4, 5]
🔥 Key Insight (MOST IMPORTANT)

👉 Partition is everything

After partition:

Pivot is at correct position
No need to touch it again
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //swap pivot
        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;

        return i + 1;
    }
}

package May2026.DSA.Day2.LearnSortingTechniques;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        //Input: N = 5, array[] = {5,4,3,2,1}
        //Output: 1,2,3,4,5
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    🧠 Idea of Selection Sort

👉 “Find the minimum element and put it at the beginning”

Round 1 → smallest element at index 0
Round 2 → 2nd smallest at index 1
and so on…
🧪 Input
[5, 4, 3, 2, 1]
🔁 Dry Run (Step-by-step)
🔹 Pass 1 (i = 0)

Find minimum from index 0 → end

Min = 1 (index 4)
Swap with index 0
[1, 4, 3, 2, 5]

👉 1 is fixed

🔹 Pass 2 (i = 1)

Find minimum from index 1 → end

Min = 2 (index 3)
Swap with index 1
[1, 2, 3, 4, 5]

👉 2 is fixed

🔹 Pass 3 (i = 2)
Min = 3 (already correct)
[1, 2, 3, 4, 5]

👉 no swap needed

🔹 Pass 4 (i = 3)
Min = 4 (already correct)

👉 Sorted 🎉

📊 Visualization (Very Important)
Initial:   [5, 4, 3, 2, 1]

Pass 1:    [1, 4, 3, 2, 5]
            ↑ fixed

Pass 2:    [1, 2, 3, 4, 5]
               ↑ fixed

Pass 3:    [1, 2, 3, 4, 5]
                  ↑ fixed

Pass 4:    [1, 2, 3, 4, 5]
                     ↑ fixed

👉 Left side becomes sorted
     */

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //now swap i with minIndex
            if (i != minIndex) {
                int t = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = t;
            }
        }
    }
}

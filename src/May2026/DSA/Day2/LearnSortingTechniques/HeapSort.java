package May2026.DSA.Day2.LearnSortingTechniques;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //Input: N = 5, array[] = {5,4,3,2,1}
        //Output: 1,2,3,4,5
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        int low = 0, high = arr.length - 1;
        heapSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    /*
    🧠 Idea of Heap Sort

👉 Use a Max Heap (parent ≥ children)

Steps:

Build max heap
Swap root (max) with last
Reduce heap size
Heapify again
🧪 Input
[5, 4, 3, 2, 1]
🔁 Step 1: Build Max Heap

Array → Tree (heap view):

        5
      /   \
     4     3
    / \
   2   1

👉 Already a max heap ✔️

🔁 Step 2: Sorting (Extract Max)
🔹 Pass 1

Swap root with last:

[1, 4, 3, 2, 5]

Heapify:

1 < 4 → swap
1 < 2 → swap
[4, 2, 3, 1, 5]

👉 5 fixed at end

🔹 Pass 2

Swap:

[1, 2, 3, 4, 5]

Heapify:

1 < 3 → swap
[3, 2, 1, 4, 5]

👉 4 fixed

🔹 Pass 3

Swap:

[1, 2, 3, 4, 5]

Heapify:

1 < 2 → swap
[2, 1, 3, 4, 5]

👉 3 fixed

🔹 Pass 4

Swap:

[1, 2, 3, 4, 5]

👉 Done 🎉

📊 Visualization (Important)
Build Heap:
[5, 4, 3, 2, 1]

Step 1:  [4, 2, 3, 1 | 5]
Step 2:  [3, 2, 1 | 4, 5]
Step 3:  [2, 1 | 3, 4, 5]
Step 4:  [1 | 2, 3, 4, 5]

Final:   [1, 2, 3, 4, 5]

👉 Right side becomes sorted (like selection sort)

🔥 Key Insight

👉 Heap gives fast access to max element

Root = largest
Remove it → fix position
Repeat
     */

    private static void heapSort(int[] arr, int low, int high) {
    }
}

package May2026.DSA.Day2.LearnSortingTechniques;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //Input: N = 5, array[] = {5,4,3,2,1}
        //Output: 1,2,3,4,5
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    🧪 Input
[5, 4, 3, 2, 1]
🔁 Pass 1 (i = 0)

Compare adjacent elements:

(5, 4) → swap → [4, 5, 3, 2, 1]
(5, 3) → swap → [4, 3, 5, 2, 1]
(5, 2) → swap → [4, 3, 2, 5, 1]
(5, 1) → swap → [4, 3, 2, 1, 5]

👉 Largest element (5) reached end

🔁 Pass 2 (i = 1)
(4, 3) → swap → [3, 4, 2, 1, 5]
(4, 2) → swap → [3, 2, 4, 1, 5]
(4, 1) → swap → [3, 2, 1, 4, 5]

👉 2nd largest (4) placed correctly

🔁 Pass 3 (i = 2)
(3, 2) → swap → [2, 3, 1, 4, 5]
(3, 1) → swap → [2, 1, 3, 4, 5]

👉 3rd largest (3) placed

🔁 Pass 4 (i = 3)
(2, 1) → swap → [1, 2, 3, 4, 5]

👉 Sorted 🎉

📊 Visualization (Key Idea)
Pass 1:  [5, 4, 3, 2, 1]  →  [4, 3, 2, 1, 5]
                                    ↑ fixed

Pass 2:  [4, 3, 2, 1, 5]  →  [3, 2, 1, 4, 5]
                                 ↑ fixed

Pass 3:  [3, 2, 1, 4, 5]  →  [2, 1, 3, 4, 5]
                              ↑ fixed

Pass 4:  [2, 1, 3, 4, 5]  →  [1, 2, 3, 4, 5]
                           ↑ fixed

👉 Right side gets sorted step-by-step
     */

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swapped=true;
                }
            }
            if(!swapped){
                break;//already sorted
            }
        }
    }
}

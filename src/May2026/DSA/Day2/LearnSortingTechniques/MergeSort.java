package May2026.DSA.Day2.LearnSortingTechniques;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        //Input: N = 5, array[] = {5,4,3,2,1}
        //Output: 1,2,3,4,5
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        int low = 0, high = arr.length - 1;
        mergeSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    /*
    🧪 Input
[5, 4, 3, 2, 1]
🔁 Step 1: DIVIDE (Recursive Splitting)
[5, 4, 3, 2, 1]
        ↓
[5, 4, 3]   [2, 1]
     ↓          ↓
[5, 4] [3]   [2] [1]
   ↓
[5] [4]

👉 Keep dividing until single elements
(Single element = already sorted)

🔁 Step 2: MERGE (Bottom-up)
🔹 Merge [5] & [4]
[5] + [4] → [4, 5]
🔹 Merge [4,5] & [3]
[4, 5] + [3] → [3, 4, 5]
🔹 Merge [2] & [1]
[2] + [1] → [1, 2]
🔹 Final Merge
[3, 4, 5] + [1, 2]
→ [1, 2, 3, 4, 5]
📊 Visualization (Full Flow)
                [5, 4, 3, 2, 1]
               /               \
        [5, 4, 3]           [2, 1]
         /     \            /    \
     [5,4]     [3]        [2]    [1]
     /   \
   [5]   [4]

---------------- MERGE ----------------

   [5] + [4] → [4,5]
   [4,5] + [3] → [3,4,5]
   [2] + [1] → [1,2]
   [3,4,5] + [1,2] → [1,2,3,4,5]
🔥 Key Insight

👉 Merge step is the MOST important part

While merging:

Compare elements from both arrays
Pick smaller one first
Build sorted array
     */
    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);

    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int k = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
}

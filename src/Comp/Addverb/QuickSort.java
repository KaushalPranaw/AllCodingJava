package Comp.Addverb;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickS(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

    private static void quickS(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionArray(arr, low, high);
            quickS(arr, low, pivot - 1);
            quickS(arr, pivot + 1, high);
        }
    }

    private static int partitionArray(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        //if element chote h pivot se to left me rakho
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

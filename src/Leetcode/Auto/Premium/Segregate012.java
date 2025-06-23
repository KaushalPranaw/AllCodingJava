package Leetcode.Auto.Premium;

public class Segregate012 {
    public static void main(String[] args) {
        int[] arr1 = {2, 0, 2, 1, 1, 0};
        segregate(arr1);
        System.out.println(java.util.Arrays.toString(arr1)); // Output: [0, 0, 1, 1, 2, 2]

    }

    public static void segregate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // Handle empty or null array
        }
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, mid, low);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

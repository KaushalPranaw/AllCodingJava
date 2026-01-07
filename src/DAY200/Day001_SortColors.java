package DAY200;

import java.util.Arrays;

public class Day001_SortColors {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 2, 2, 1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortColors(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int current = 0;
        while (current <= right) {
            if (arr[current] == 0) {
                swaps(current, left, arr);
                current++;
                left++;
            } else if (arr[current] == 1) {
                current++;
            } else if (arr[current] == 2) {
                swaps(current, right, arr);
                right--;
            }
        }
    }

    private static void swaps(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

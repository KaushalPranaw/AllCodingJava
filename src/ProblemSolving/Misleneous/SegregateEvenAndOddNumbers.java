package ProblemSolving.Misleneous;

import java.util.Arrays;

public class SegregateEvenAndOddNumbers {
    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 4, 6, 1, 3, 8, 5};
        System.out.println(Arrays.toString(arr));
        segregateEvenAndOddNumbers(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void segregateEvenAndOddNumbers(int[] arr) {
        int j = 0;//for even num
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }
}

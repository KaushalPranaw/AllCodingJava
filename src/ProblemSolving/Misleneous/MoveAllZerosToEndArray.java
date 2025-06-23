package ProblemSolving.Misleneous;

import java.util.Arrays;

public class MoveAllZerosToEndArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println(Arrays.toString(arr));
        moveAllZerosToEndArray(arr);
        System.out.println(Arrays.toString(moveAllZerosToEndArray(arr)));
    }


    //Using O(n) space
    /*private static int[] moveAllZerosToEndArray(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[index++] = arr[i];
            }
        }
        return temp;
    }*/

    /*private static int[] moveAllZerosToEndArray(int[] arr) {
        int n = arr.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        while (index < n) {
            arr[index++] = 0;
        }
        return arr;
    }*/

    private static int[] moveAllZerosToEndArray(int[] arr) {
        int n = arr.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int t = arr[i];
                arr[i] = arr[index];
                arr[index] = t;
                index++;
            }
        }
        return arr;
    }
}

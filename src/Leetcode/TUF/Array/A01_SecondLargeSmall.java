package Leetcode.TUF.Array;

public class A01_SecondLargeSmall {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 7, 7, 5};
        int n = arr.length;
        int sS = secondSmallestElement(arr, n);
        int sL = secondLargestElement(arr, n);
        System.out.println("Second smallest is " + sS);
        System.out.println("Second largest is " + sL);
    }

    private static int secondLargestElement(int[] arr, int n) {
        int large = Integer.MIN_VALUE;
        int second = large;
        for (int i = 0; i < n; i++) {
            if (arr[i] > large) {
                second = large;
                large = arr[i];
            } else if (arr[i] > second && arr[i] != large) {
                second = arr[i];
            }
        }
        return second;
    }

    private static int secondSmallestElement(int[] arr, int n) {
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small) {
                secondSmall = small;
                small = arr[i];
            } else if (secondSmall > arr[i] && arr[i] != small) {
                secondSmall = arr[i];
            }
        }
        return secondSmall != Integer.MAX_VALUE ? secondSmall : -1;
    }
}

package May2026.DSA.Day3.DSA;

public class D02_FindSecondSmallestAndSecondLargestElementInArray {
    public static void main(String[] args) {
        // Array of elements
        int[] arr = {1, 2, 4, 7, 7, 5};

        // Find the second smallest and second-largest elements
        int sS = secondSmallest(arr);
        int sL = secondLargest(arr);

        // Output the results
        System.out.println("Second smallest is " + sS);
        System.out.println("Second largest is " + sL);

    }

    private static int secondLargest(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return -1;
        }
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (large < arr[i]) {
                secondLarge = large;
                large = arr[i];
            } else if (secondLarge < arr[i] && large != arr[i]) {
                secondLarge = arr[i];
            }
        }
        return secondLarge == Integer.MIN_VALUE ? -1 : secondLarge;
    }

    private static int secondSmallest(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return -1;
        }

        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (small > arr[i]) {
                secondSmall = small;
                small = arr[i];
            } else if (secondSmall > arr[i] && small != arr[i]) {
                secondSmall = arr[i];
            }
        }
        return secondSmall == Integer.MAX_VALUE ? -1 : secondSmall;
    }
}

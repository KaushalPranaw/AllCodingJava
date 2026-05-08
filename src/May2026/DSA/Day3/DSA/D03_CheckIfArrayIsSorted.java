package May2026.DSA.Day3.DSA;

public class D03_CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        // Output result
        System.out.println(isSorted(arr, n) ? "True" : "False");
    }

    private static boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}

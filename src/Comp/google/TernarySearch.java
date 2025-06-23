package Comp.google;

public class TernarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Key to be searched in the array
        int key = 5;

        // Search the key using ternarySearch
        int p = ternarySearch(0, arr.length - 1, key, arr);

        // Print the result
        System.out.println("Index of " + key + " is " + p);

    }

    private static int ternarySearch(int l, int r, int key, int[] arr) {
        int m1 = l + (r - l) / 3;
        int m2 = r - (r - l) / 3;

        if (arr[m1] == key) {
            return m1;
        } else if (arr[m2] == key) {
            return m2;
        } else if (key < arr[m1]) {
            return ternarySearch(l, m1 - 1, key, arr);
        } else if (key > arr[m2]) {
            return ternarySearch(m2 + 1, r, key, arr);
        } else {
            return ternarySearch(m1 + 1, m2 - 1, key, arr);
        }
    }
}

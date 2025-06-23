package ProblemSolving.Searching;

public class SearchSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int index = find(arr, key);
        System.out.println(index);
    }

    static int find(int[] arr, int key) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) {
                return m;
            }
            if (arr[m] >= arr[l]) {
                if (key >= arr[l] && key < arr[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (key > arr[m] && key <= arr[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}

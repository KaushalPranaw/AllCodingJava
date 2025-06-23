package ProblemSolving.Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int target = 4;
        int index = linearSearch(arr, target);
        System.out.println(index);
    }

    static int linearSearch(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

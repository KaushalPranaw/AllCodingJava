package ProblemSolving.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int target = 4;
        int index = binarySearch(arr, target);
        System.out.println(index);
    }

    static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

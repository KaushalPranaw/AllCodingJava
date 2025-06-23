package Comp.google;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        // Sample Input 1
        int[] arr1 = {12, 34, 67, 90};
        int k1 = 2;
        System.out.println("Sample Input 1: " + findPages(arr1, arr1.length, k1)); // Expected Output: 113

        // Sample Input 2
        int[] arr2 = {15, 17, 20};
        int k2 = 5;
        System.out.println("Sample Input 2: " + findPages(arr2, arr2.length, k2)); // Expected Output: -1

        // Sample Input 3
        int[] arr3 = {22, 23, 67};
        int k3 = 1;
        System.out.println("Sample Input 3: " + findPages(arr3, arr3.length, k3)); // Expected Output: 112
    }
    public static int findPages(int[] arr, int n, int k) {
        if(n<k){
            return -1;
        }

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int num: arr){
            high+=num;
            if(num>low){
                low=num;
            }
        }
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int k, int maxPages) {
        int students = 1;
        int currentSum = 0;

        for (int num : arr) {
            if (currentSum + num > maxPages) {
                students++;
                currentSum = num;
                if (students > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}

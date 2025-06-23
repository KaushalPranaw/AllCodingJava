package Leetcode.Auto.Premium;

import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 13;
        findTriplets(arr, target);
    }

    public static void findTriplets(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[l] + arr[r] + arr[i];
                if (sum == target) {
                    System.out.println("Triplet: " + arr[i] + ", " + arr[l] + ", " + arr[r]);
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
    }
}

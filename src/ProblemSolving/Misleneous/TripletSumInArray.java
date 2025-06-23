package ProblemSolving.Misleneous;

import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 10, 8}, target = 13;
        System.out.println(tripletSum(arr, target));
    }

    private static boolean tripletSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            int requiredSum = target - arr[i];

            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum == requiredSum) {
                    return true;
                } else if (sum < requiredSum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return false;

    }
}

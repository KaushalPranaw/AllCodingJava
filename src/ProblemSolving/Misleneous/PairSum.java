package ProblemSolving.Misleneous;

import java.util.Arrays;

public class PairSum {
    public static void main(String[] args) {
        int arr[] = {10, 20, 35, 50}, target = 70;
        System.out.println(Arrays.toString(pairSum(arr, target)));
    }

    private static int[] pairSum(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                return new int[]{l, r};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{};
    }
}

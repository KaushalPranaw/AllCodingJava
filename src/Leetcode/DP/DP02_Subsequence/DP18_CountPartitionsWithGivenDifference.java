package Leetcode.DP.DP02_Subsequence;

import java.util.Arrays;

public class DP18_CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 4};
        int d = 3;

        System.out.println("The number of subsets found are " + countPartitions(d, arr));
    }

    private static int countPartitions(int d, int[] arr) {

        /*
        we also know

        s1+s2=totalSum
        s1=totalSum-s2;

        s1-s2=d
        (totalSum-s2)-s2=d
        totalSum-d=2* s2
        s2=(totalSum-d)/2;

         */
        int totalSum = Arrays.stream(arr).sum();
        return findWays(arr, (totalSum - d) / 2);
    }

    private static int findWays(int[] arr, int k) {
        int[] prev = new int[k + 1];
        if (arr[0] == 0) {
            prev[0] = 2;//take & not_take
        } else {
            prev[0] = 1;//not pick
        }

        if (arr[0] != 0 && k >= arr[0])// 1 case -pick
            prev[arr[0]] = 1;

        int n = arr.length;

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[k + 1];
            cur[0] = 1;
            for (int target = 0; target <= k; target++) {
                int not_take = prev[target];
                int take = 0;
                if (target - arr[ind] >= 0) {
                    take = prev[target - arr[ind]];
                }
                cur[target] = not_take + take;
            }
            prev = cur.clone();
        }
        return prev[k];
    }
}

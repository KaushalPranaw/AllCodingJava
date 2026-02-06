package Leetcode.DP.DP00_1D_2D;

//https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/
public class DP06_HouseRobber2 {
    public static void main(String[] args) {
        // Input array with elements.
        int arr[] = {1, 5, 1, 2, 6};//output 11
        int n = arr.length;

        System.out.println(circularMaxHouse(arr, n));
    }

    private static int circularMaxHouse(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        int[] arr1 = new int[n - 1]; // exclude first
        int[] arr2 = new int[n - 1]; // exclude last

        for (int i = 0; i < n - 1; i++) {
            arr1[i] = arr[i + 1]; // skip first
            arr2[i] = arr[i];     // skip last
        }
        return Math.max(maxHouse(n - 1, arr1), maxHouse(n - 1, arr2));
    }

    /*//recur+memo
    private static int maxHouse(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxHouseHelper(n - 1, arr, dp);
    }

    private static int maxHouseHelper(int ind, int[] arr, int[] dp) {
        if (ind == 0) {
            return arr[ind];
        }
        if (ind < 0) {
            return 0;
        }

        if (dp[ind] != -1)
            return dp[ind];

        int pick = arr[ind] + maxHouseHelper(ind - 2, arr, dp);
        int not_pick = 0 + maxHouseHelper(ind - 1, arr, dp);
        return dp[ind] = Math.max(pick, not_pick);
    }*/

    /*//tab
    private static int maxHouse(int n, int[] arr) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int ind = 1; ind < n; ind++) {
            int pick = 0;
            if (ind > 1)
                pick = arr[ind] + dp[ind - 2];
            int not_pick = 0 + dp[ind - 1];
            dp[ind] = Math.max(pick, not_pick);
        }
        return dp[n - 1];
    }*/

    //space
    private static int maxHouse(int n, int[] arr) {

        int prev = arr[0];
        int prevOfPrev = 0;

        for (int ind = 1; ind < n; ind++) {
            int pick = 0;
            if (ind > 1)
                pick = arr[ind] + prevOfPrev;
            int not_pick = 0 + prev;
            int cur = Math.max(pick, not_pick);
            prevOfPrev = prev;
            prev = cur;
        }
        return prev;
    }


}

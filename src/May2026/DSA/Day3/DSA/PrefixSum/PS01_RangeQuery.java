package May2026.DSA.Day3.DSA.PrefixSum;

public class PS01_RangeQuery {
    public static void main(String[] args) {
        //Example 1:
        //Input: arr[] = {1, 2, 3, 4, 5}, L = 1, R = 3
        //Output: 9
        //Explanation: The sum of elements from index 1 to index 3 is (2 + 3 + 4) = 9.
        int[] arr = {1, 2, 3, 4, 5};
        int L = 1;
        int R = 3;

        int result = rangeSum(arr, L, R);

        System.out.println("Range sum from index " + L + " to index " + R + ": " + result);
    }

    private static int rangeSum(int[] arr, int l, int r) {
        int n = arr.length;

        //create prefix sum array
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        //calculate range sum
        //formula: sum(L,R)=prefixSum[R]-prefixSum[L-1]
        if (l == 0) {
            return prefixSum[r];
        }
        return prefixSum[r] - prefixSum[l - 1];
    }
}

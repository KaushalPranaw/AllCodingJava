package Leetcode.TUF.BinarySearch.BS03;

public class BS15_NthRootOfNumberUsingBinarySearch {
    public static void main(String[] args) {
        //Example 1:
        //Input Format: N = 3, M = 27
        //Result: 3
        //Explanation: The cube root of 27 is equal to 3.
        //
        //Example 2:
        //Input Format: N = 4, M = 69
        //Result: -1
        //Explanation: The 4th root of 69 does not exist. So, the answer is -1.

        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }

    private static int NthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }

    //Return 1 if mid == m
    //Return 0 if mid < m
    //Return 2 if mid > m
    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }
}

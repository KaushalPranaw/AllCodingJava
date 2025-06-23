package Leetcode.TUF.BinarySearch.BS03;

public class BS14_FindingSqrtOfNumber {
    public static void main(String[] args) {
        //Input Format: n = 36
        //Result: 6
        //Explanation: 6 is the square root of 36.
        //
        //Example 2:
        //Input Format: n = 28
        //Result: 5

        int n = 28;
        int ans = floorSqrt(n);
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }

    private static int floorSqrt(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int low = 1, high = n;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            /*int val = mid * mid;//overflow ho jayega
            if (val <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }*/

            if (mid <= n / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return ans;
    }
}

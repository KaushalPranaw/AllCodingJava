package Leetcode.Leetcode150.Math;

public class Sqrt {
    public static void main(String[] args) {
        int x = 25;
        System.out.println(new Sqrt().mySqrt(x));
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int res = 0;

        int low = 0, high = x;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid * mid <= x) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}

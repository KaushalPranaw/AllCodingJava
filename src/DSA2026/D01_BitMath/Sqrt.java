package DSA2026.D01_BitMath;

public class Sqrt {
    public static void main(String[] args) {
        int x=8;
        System.out.println(new Sqrt().mySqrt(x));
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int start = 0, end = x;
        int res = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                res = (int) mid;
                start = (int) mid + 1;
            } else {
                end = (int) mid - 1;
            }
        }
        return res;
    }
}

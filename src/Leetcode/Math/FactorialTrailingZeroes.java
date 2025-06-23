package Leetcode.Math;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(n));

    }

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}

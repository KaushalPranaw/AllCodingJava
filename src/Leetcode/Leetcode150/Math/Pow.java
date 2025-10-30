package Leetcode.Leetcode150.Math;

public class Pow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(new Pow().myPow(x, n));
    }

    private double myPow(double base, int n) {
        long exp = n;
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            exp = -exp;
            base = 1 / base;
        }

        double res = 1;
        while (exp != 0) {
            if (exp % 2 == 1) {
                res = res * base;
            }
            base = base * base;
            exp = exp / 2;
        }
        return res;

    }

}
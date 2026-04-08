package DSA2026.D01_BitMath;

public class Power {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double base, int n) {
        int exp = n;
        if (exp == 0) {
            return 1;
        }

        if (exp < 0) {
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

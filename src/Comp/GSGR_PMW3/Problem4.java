package Comp.GSGR_PMW3;

public class Problem4 {
    public static void main(String[] args) {
        double base = 2.0;
        int exp = 5;
        System.out.println(power(base, exp));
    }

    /*public static double power(double base, int exp) {
        // Base case: if exponent is 0, return 1 as anything raised to 0 is 1
        if (exp == 0) {
            return 1;
        }

        // If exponent is negative, invert the base and make the exponent positive
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;
        }

        double result = 1.0;
        // Use fast exponentiation (exponentiation by squaring) for efficient computation
        while (exp != 0) {
            if (exp % 2 == 1) {
                result *= base;
            }
            base *= base;
            exp /= 2;
        }
        return result;
    }*/

    public static double power(double base, int exp) {
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
            exp /= 2;
        }
        return res;
    }
}

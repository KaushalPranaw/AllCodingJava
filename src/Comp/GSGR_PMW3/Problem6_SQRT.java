package Comp.GSGR_PMW3;

public class Problem6_SQRT {
    public static void main(String[] args) {
        // Test cases
        System.out.println(squareRoot(4));   // Output: 2.0
        System.out.println(squareRoot(2));   // Output: Approximately 1.41421
        System.out.println(squareRoot(9));   // Output: 3.0
        System.out.println(squareRoot(0.25)); // Output: 0.5
    }

    /*private static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number.");
        }

        // Special cases for 0 and 1
        if (x == 0 || x == 1) {
            return x;
        }

        double low = 0;
        double high = x;
        double epsilon = 1e-6; // Desired precision
        double mid = 0;

        // Binary search for square root
        while (high - low > epsilon) {
            mid = (low + high) / 2.0;

            if (mid * mid > x) {
                high = mid; // Square root is less than mid
            } else {
                low = mid; // Square root is greater than mid
            }
        }

        return (low + high) / 2.0; // Final approximation
    }*/

    private static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("illegal num");
        }

        if (x == 0 || x == 1) {
            return x;
        }

        double epsilon = 1e-6;

        double l = 0, r = x < 1 ? 1 : x;
        while (r - l > epsilon) {
            double m = l + (r - l) / 2;
            if (m * m > x) {
                r = m;
            } else {
                l = m;
            }
        }
        return (l + r) / 2;


    }
}

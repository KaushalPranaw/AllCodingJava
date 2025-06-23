package Comp.GSGR_PMW3;

public class Problem24_PascalTriangle {
    public static void main(String[] args) {
        // Test cases
        System.out.println(pascal(0, 0)); // Output: 1
        System.out.println(pascal(1, 2)); // Output: 2
        System.out.println(pascal(4, 8)); // Output: 70
        System.out.println(pascal(5, 10)); // Output: 252
    }

    public static int pascal(int col, int row) {
        // Base case: if col == 0 or col == row, the value is always 1
        if (col == 0 || col == row) {
            return 1;
        }

        // Calculate the binomial coefficient using the formula: row! / (col! * (row - col)!)
        return binomialCoefficient(row, col);
    }

    private static int binomialCoefficient(int n, int k) {
        // Since C(n, k) = C(n, n-k), take the smaller k to reduce computations
        if (k > n - k) {
            k = n - k;
        }

        int result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1); // Efficient computation avoiding factorials
        }

        return result;
    }
}

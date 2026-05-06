package May2026.DSA.Day1.LearnBasicRecursion;

public class R05_FactorialOfNumber {
    public static void main(String[] args) {
        int n = 5;
        int fact = factorialOfNumber(n);
        System.out.println(fact);
    }

    private static int factorialOfNumber(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorialOfNumber(n - 1);
    }
}

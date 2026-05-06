package May2026.DSA.Day1.LearnBasicRecursion;

public class R06_RecursiveFibonacci {
    public static void main(String[] args) {
        int N = 4;
        System.out.println(fibonacci(N));  // Output: 3
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);
        return last + secondLast;
    }
}

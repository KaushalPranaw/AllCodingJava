package DSA2026.D01_BitMath;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(trailingZeroes(n));

        /*
        n = 5
        5! = 5 × 4 × 3 × 2 × 1 = 120
        👉 End me zero = 1

        Example 3:
        n = 10
        10! = 3628800
        👉 End me zero = 2
         */
    }

    public static int trailingZeroes(int n) {
        /*
        So in n!:

        Count of 2s is always more
        Count of 5s is limiting factor

        👉 So the problem reduces to:

        Count how many times 5 appears in factors of numbers from 1 to n
         */

        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;

        //n = 25
        //25/5   = 5
        //25/25  = 1
        //25/125 = 0
        //Total = 5 + 1 = 6

    }
}

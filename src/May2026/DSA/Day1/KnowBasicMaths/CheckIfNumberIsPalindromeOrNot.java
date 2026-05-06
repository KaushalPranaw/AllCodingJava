package May2026.DSA.Day1.KnowBasicMaths;

public class CheckIfNumberIsPalindromeOrNot {
    public static void main(String[] args) {
        int n = 4554;
        System.out.println(checkIfNumberIsPalindromeOrNot(n));
    }

    private static boolean checkIfNumberIsPalindromeOrNot(int n) {
        int temp = n;
        int rev = 0;
        while (temp > 0) {
            int d = temp % 10;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                rev = 0;
            }
            rev = rev * 10 + d;
            temp = temp / 10;
        }
        return rev == n;
    }
}

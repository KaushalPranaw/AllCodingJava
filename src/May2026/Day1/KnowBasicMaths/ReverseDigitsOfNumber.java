package May2026.Day1.KnowBasicMaths;

public class ReverseDigitsOfNumber {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(reverseDigitsOfNumber(n));
    }

    private static int reverseDigitsOfNumber(int n) {
        int rev = 0;
        while (n > 0) {
            int digit = n % 10;

            //handle overflow
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0; // or handle accordingly
            }

            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }
}

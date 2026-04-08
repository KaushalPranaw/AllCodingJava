package DSA2026.D01_BitMath;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        int y = -121;
        System.out.println(new PalindromeNumber().isPalindrome(x));//true
        System.out.println(new PalindromeNumber().isPalindrome(y));//false

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum = sum * 10 + rem;
            num /= 10;
        }
        return sum == x;
    }
}

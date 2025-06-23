package Leetcode.Math;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(new PalindromeNumber().isPalindrome(x));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int temp = x;
        while (temp != 0) {
            reverse = reverse * 10 + (temp % 10);
            temp = temp / 10;
        }
        return reverse == x;

    }
}

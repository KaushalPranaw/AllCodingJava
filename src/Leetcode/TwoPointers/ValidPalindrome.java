package Leetcode.TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));

    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
        }
        return true;
    }
}

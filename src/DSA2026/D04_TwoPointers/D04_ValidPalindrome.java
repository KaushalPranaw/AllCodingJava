package DSA2026.D04_TwoPointers;

public class D04_ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char chLeft = s.charAt(left);
            char chRight = s.charAt(left);
            if (!Character.isLetterOrDigit(chLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(chRight)) {
                right--;
            } else {
                if (Character.toLowerCase(chLeft) != Character.toLowerCase(chRight)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return true;

    }
}

package Leetcode.TUF.String;

public class S02_LargestOddNumberFinder {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("5347"));    // Output: 5347
        System.out.println(largestOddNumber("0214638")); // Output: 21463
        System.out.println(largestOddNumber("100"));     // Output: ""
    }

    private static String largestOddNumber(String s) {
        // Iterate from end of the string to the beginning
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if ((c - '0') % 2 == 1) {
                //remove leading zeros
                int start = 0;
                while (start < i + 1 && s.charAt(start) == '0') {
                    start++;
                }
                return s.substring(start, i + 1);
            }
        }
        return "";
    }
}

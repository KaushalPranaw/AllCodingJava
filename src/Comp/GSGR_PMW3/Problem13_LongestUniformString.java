package Comp.GSGR_PMW3;

public class Problem13_LongestUniformString {
    public static void main(String[] args) {
        // Test cases
        String input1 = "abbbccda";
        int[] result1 = longestUniformSubstring(input1);
        System.out.println("Input: " + input1 + ", Output: [" + result1[0] + ", " + result1[1] + "]");

        String input2 = "aabbbbbCdAA";
        int[] result2 = longestUniformSubstring(input2);
        System.out.println("Input: " + input2 + ", Output: [" + result2[0] + ", " + result2[1] + "]");

        String input3 = "";
        int[] result3 = longestUniformSubstring(input3);
        System.out.println("Input: " + input3 + ", Output: [" + result3[0] + ", " + result3[1] + "]");

        String input4 = "a";
        int[] result4 = longestUniformSubstring(input4);
        System.out.println("Input: " + input4 + ", Output: [" + result4[0] + ", " + result4[1] + "]");

        String input5 = "abbbbbbbcd";
        int[] result5 = longestUniformSubstring(input5);
        System.out.println("Input: " + input5 + ", Output: [" + result5[0] + ", " + result5[1] + "]");
    }

    /*private static int[] longestUniformSubstring(String input) {

        if (input == null || input.length() == 0) {
            return new int[]{0, 0};
        }
        // Variables to keep track of the longest uniform substring
        int maxStartIndex = 0; // Start index of the longest uniform substring
        int maxLength = 0;     // Length of the longest uniform substring

        int currentStartIndex = 0; // Start index of the current uniform substring
        int currentLength = 1;     // Length of the current uniform substring

        // Loop through the input string to find uniform substrings
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                // If the current character matches the previous one, increase the length of the current substring
                currentLength++;
            } else {
                // If the current character is different, check if the current substring is the longest
                if (currentLength > maxLength) {
                    maxStartIndex = currentStartIndex;
                    maxLength = currentLength;
                }
                // Reset the current substring variables
                currentStartIndex = i; // Start index of the new uniform substring
                currentLength = 1;     // Reset length to 1 because it's a new substring
            }
        }
        // Perform a last check after looping in case the longest substring was at the end
        if (currentLength > maxLength) {
            maxStartIndex = currentStartIndex;
            maxLength = currentLength;
        }
        return new int[]{maxStartIndex, maxLength};

    }*/

    private static int[] longestUniformSubstring(String input) {

        if (input == null || input.length() == 0) {
            return new int[]{0, 0};
        }

        int maxStart = 0;
        int maxLen = 1;
        int curStart = 0;
        int curLen = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                curLen++;
            } else {
                if (maxLen < curLen) {
                    maxLen = curLen;
                    maxStart = curStart;
                }
                curStart = i;
                curLen = 1;
            }
        }
        // Final check (for the last uniform substring)
        if (maxLen < curLen) {
            maxLen = curLen;
            maxStart = curStart;
        }
        return new int[]{maxStart, maxLen};

    }
}

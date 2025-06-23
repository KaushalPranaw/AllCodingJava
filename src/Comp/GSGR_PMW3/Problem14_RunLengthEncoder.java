package Comp.GSGR_PMW3;

public class Problem14_RunLengthEncoder {
    public static void main(String[] args) {
        System.out.println(rle("aaabbbaad")); // a3b3a2d1
        System.out.println(rle("a"));         // a1
        System.out.println(rle("aabbb"));     // a2b3
        System.out.println(rle("aabbbaa"));   // a2b3a2
    }

    private static String rle(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == input.charAt(i)) {
                count++;
            } else {
                sb.append(input.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }
        sb.append(input.charAt(input.length() - 1));
        sb.append(count);
        return sb.toString();

    }

    /*private static String rle(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        // Append the last character and its count
        encoded.append(input.charAt(input.length() - 1)).append(count);

        return encoded.toString();

    }*/

}

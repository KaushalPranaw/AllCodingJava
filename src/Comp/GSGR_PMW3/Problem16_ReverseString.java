package Comp.GSGR_PMW3;

import java.util.stream.IntStream;

public class Problem16_ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcd"));  // Output: "dcba"
        System.out.println(reverseStr(""));      // Output: ""
        System.out.println(reverseStr(null));    // Output: null
    }

    public static String reverseStr(String str) {
        if (str == null) {
            return null;
        }
        /*return IntStream.range(0, str.length())
                .map(i -> str.charAt(str.length() - 1 - i))
                .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                .toString();*/

        char[] ca = str.toCharArray();
        int l = 0, r = ca.length - 1;
        while (l < r) {
            char t = ca[l];
            ca[l] = ca[r];
            ca[r] = t;
            l++;
            r--;
        }
        return new String(ca);

    }
}

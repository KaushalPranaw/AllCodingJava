package Comp.EDJO;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello, World!";
        /*char[] sa = str.toCharArray();
        reverseSA(sa);
        String reversed = new String(sa);
        System.out.println(reversed);*/

        String reversedStr = IntStream.range(0, str.length())
                .map(i -> str.charAt(str.length() - 1 - i)) // Map each index to its reverse character
                .mapToObj(c -> String.valueOf((char) c))    // Convert each character back to a string
                .collect(Collectors.joining());             // Join all characters into a single string

        System.out.println(reversedStr);



    }

    private static void reverseSA(char[] sa) {
        int left = 0, right = sa.length - 1;
        while (left < right) {
            char t = sa[left];
            sa[left] = sa[right];
            sa[right] = t;
            left++;
            right--;
        }
    }


}

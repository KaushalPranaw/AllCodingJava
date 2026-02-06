package Leetcode.Leetcode150.Array_String;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new ReverseWordsInAString().reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] sa = s.trim().split(" ");
        int i = 0, j = sa.length - 1;
        while (i < j) {
            String temp = sa[i];
            sa[i] = sa[j];
            sa[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", sa);
    }
}

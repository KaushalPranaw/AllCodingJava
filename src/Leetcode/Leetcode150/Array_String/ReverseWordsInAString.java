package Leetcode.Leetcode150.Array_String;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new ReverseWordsInAString().reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] sa = s.split(" ");
        int l = 0, r = sa.length - 1;
        while (l < r) {
            String t = sa[l];
            sa[l] = sa[r];
            sa[r] = t;
            l++;
            r--;
        }
        return String.join(" ", sa);
    }
}

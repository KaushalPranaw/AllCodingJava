package Leetcode.TUF.String;

public class S01_ReverseWordsInString {
    public static void main(String[] args) {
        //Input: s=”this is an amazing program”
        //Output: “program amazing an is this”
        String s = "this is an amazing program";
        System.out.println(reversedWords(s));
    }

    private static String reversedWords(String s) {
        String[] sa = s.split(" ");
        reverse(sa);
        return String.join(" ", sa);
    }

    static void reverse(String[] sa) {
        int l = 0, r = sa.length - 1;
        while (l <= r) {
            String t = sa[l];
            sa[l] = sa[r];
            sa[r] = t;
            l++;
            r--;
        }
    }

}

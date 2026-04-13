package DSA2026.D03_Array_String;

public class ReverseWordsInString {
    public static void main(String[] args) {
        //Input: s = "the sky is blue"
        //Output: "blue is sky the"
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim());

        // Step 1: reverse whole string
        reverse(sb, 0, s.length() - 1);
        // Step 2: reverse each word
        int start = 0;
        for (int end = 0; end <= sb.length(); end++) {
            if (end == sb.length() || sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                start = end + 1;
            }
        }

        // Step 3: remove extra spaces
        return cleanspaces(sb);
    }

    private static String cleanspaces(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        int i = 0, n = sb.length();

        while (i < n) {
            while (i < n && sb.charAt(i) == ' ') i++; // skip spaces
            while (i < n && sb.charAt(i) != ' ') res.append(sb.charAt(i++));
            while (i < n && sb.charAt(i) == ' ') i++; // skip spaces
            if (i < n) res.append(" ");
        }
        return res.toString();
    }

    private static void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }

    /*public static String reverseWords(String s) {
        String[] sa=s.split(" ");
        int l=0, r=sa.length-1;
        while (l<r){
            String temp=sa[l];
            sa[l]=sa[r];
            sa[r]=temp;
            l++;
            r--;
        }
        return String.join(" ", sa);
    }*/
}

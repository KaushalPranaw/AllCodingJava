package DSA2026.D03_Array_String;

public class LengthOfLastWord {
    public static void main(String[] args) {
        //Input: s = "   fly me   to   the moon  "
        //Output: 4
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
            } else {
                if (len > 0) {
                    return len;
                }
            }
        }
        return len;
    }
}

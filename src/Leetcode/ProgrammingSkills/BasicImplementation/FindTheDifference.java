package Leetcode.ProgrammingSkills.BasicImplementation;

public class FindTheDifference {
    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(new FindTheDifference().findTheDifference(s, t));
    }

    /*public char findTheDifference(String s, String t) {
        int[] ca = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ca[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            ca[t.charAt(i) - 'a']--;
            if (ca[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }*/
    //using xor
    /*
        1^1=0
        0^0=0
        1^0=1
        0^1=1
        a^0=a
    */
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray()) {
            c ^= cs;
        }
        for (char ct : t.toCharArray()) {
            c ^= ct;
        }
        return c;
    }
}

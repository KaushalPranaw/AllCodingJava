package Leetcode.Leetcode150.Array_String;

public class ZigzagConversion {
    public static void main(String[] args) {

        String s = "PAYPALISHIRING";

        //PAHNAPLSIIGYIR
        int numRows = 3;
        System.out.println(new ZigzagConversion().convert(s, numRows));
        /*
         * p   a   h
         * a p l s i
         * y   i
         *
         *
         * */
    }

    public String convert(String s, int numRows) {
        //base case
        if (numRows == 1) {
            return s;
        }

        //initialize
        StringBuilder[] sba = new StringBuilder[numRows];
        for (int i=0;i<numRows;i++) {
            sba[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            for (int index = 0; index < numRows && i < s.length(); index++) {
                sba[index].append(s.charAt(i));
                i++;
            }

            for (int index = numRows - 2; index >= 1 && i < s.length(); index--) {
                sba[index].append(s.charAt(i));
                i++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sba) {
            res.append(sb);
        }
        return res.toString();
    }

}

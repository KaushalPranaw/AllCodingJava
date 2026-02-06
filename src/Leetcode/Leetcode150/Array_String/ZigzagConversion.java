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
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            for (int index = 0; index < numRows && i < s.length(); index++) {
                rows[index].append(s.charAt(i++));
            }

            for (int index = numRows - 2; index > 0 && i < s.length(); index--) {
                rows[index].append(s.charAt(i++));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (var row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }
}

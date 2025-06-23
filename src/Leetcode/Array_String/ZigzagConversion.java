package Leetcode.Array_String;

public class ZigzagConversion {
    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
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
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                rows[j].append(s.charAt(i));
                i++;
            }

            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                rows[j].append(s.charAt(i));
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            sb.append(rows[j]);
        }
        return sb.toString();
    }
}

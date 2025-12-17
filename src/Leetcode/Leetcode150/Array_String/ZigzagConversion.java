package Leetcode.Leetcode150.Array_String;

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

        //creating rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        //populate rows
        int i = 0;
        while (i < s.length()) {
            //upr se niche wala
            for (int index = 0; index < numRows && i < s.length(); index++) {
                rows[index].append(s.charAt(i++));
            }

            //niche se upar diagnoal wala
            for (int index = numRows - 2; index > 0 && i < s.length(); index--) {
                rows[index].append(s.charAt(i++));
            }
        }

        //now combine rows
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}

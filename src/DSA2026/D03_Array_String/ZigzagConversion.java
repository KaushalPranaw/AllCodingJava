package DSA2026.D03_Array_String;

public class ZigzagConversion {
    public static void main(String[] args) {
        //Input: s = "PAYPALISHIRING", numRows = 3
        //Output: "PAHNAPLSIIGYIR"
        //         PAHNAPLSIIGYIR
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            for (int index = 0; index < numRows && i < s.length(); index++) {
                sb[index].append(s.charAt(i));
                i++;
            }
            for (int index = numRows - 2; index > 0 && i < s.length(); index--) {
                sb[index].append(s.charAt(i));
                i++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            res.append(sb[j]);
        }

        return res.toString();
    }
}

package DSA2026.D03_Array_String;

public class IntegerToRoman {
    public static void main(String[] args) {
        //Input: num = 3749
        //
        //Output: "MMMDCCXLIX"
        int num = 3749;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}

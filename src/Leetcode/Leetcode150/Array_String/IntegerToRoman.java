package Leetcode.Leetcode150.Array_String;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(new IntegerToRoman().intToRoman(num));

    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num >= values[i]) {
                res.append(symbols[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return res.toString();
    }
}

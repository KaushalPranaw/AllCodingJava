package Leetcode.Math;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {8, 9, 9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] r = new int[digits.length + 1];
            r[0] = 1;
            return r;
        }
        return digits;

    }
}

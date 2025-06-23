package Comp.GSGR_PMW3;

import java.util.*;

public class Problem7_FractionToDecimal {
    public static void main(String[] args) {
        // Test cases
        System.out.println(vulgarToDecimal(1L, 2L).equals("0.5"));          // Output: 0.5
        System.out.println(vulgarToDecimal(1L, 3L).equals("0.(3)"));        // Output: 0.(3)
        System.out.println(vulgarToDecimal(1L, 30L).equals("0.0(3)"));      // Output: 0.0(3)
        System.out.println(vulgarToDecimal(1L, 75L).equals("0.01(3)"));     // Output: 0.01(3)
        System.out.println(vulgarToDecimal(4L, 7L).equals("0.(571428)"));   // Output: 0.(571428)
    }

    /*private static String vulgarToDecimal(Long numerator, Long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
        // Handle cases where numerator is 0 (result is always 0 regardless of denominator)
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        // Handle the sign of the result
        if (numerator < 0 ^ denominator < 0) {// XOR for differing signs
            result.append("-");
        }

        // Convert to positive numbers since we've handled the sign
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        // Append the integer part of the division
        result.append(numerator / denominator);
        long remainder = numerator % denominator;

        // If there's no remainder, it's a finite decimal
        if (remainder == 0) {
            return result.toString();
        }

        // Otherwise, handle the fractional part
        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            // Check if this remainder has been seen before
            if (remainderMap.containsKey(remainder)) {
                int startIndex = remainderMap.get(remainder); // Index where this remainder first appeared
                result.insert(startIndex, "(");
                result.append(")");
                break;
            }
            // Record the current position for this remainder
            remainderMap.put(remainder, result.length());

            remainder *= 10; // Simulate "bringing down" the next digit
            result.append(remainder / denominator); // Append the next digit
            remainder %= denominator; // Update the new remainder
        }

        return result.toString();
    }*/

    private static String vulgarToDecimal(Long numerator, Long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
        // Handle cases where numerator is 0 (result is always 0 regardless of denominator)
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        if (numerator < 0 ^ denominator < 0) {
            //if dono true or false then false else true
            //1^1=0
            //1^0=1
            //0^1=1
            //1^1=0
            //mtlb dono less than 0
            sb.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        sb.append(numerator / denominator);

        long rem = numerator % denominator;
        if (rem == 0) {
            return sb.toString();
        }
        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int startIndex = map.get(rem);
                sb.insert(startIndex, "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());//we have to find the index
            rem = rem * 10;
            sb.append(rem / denominator);
            rem = rem % denominator;
        }
        return sb.toString();
    }
}

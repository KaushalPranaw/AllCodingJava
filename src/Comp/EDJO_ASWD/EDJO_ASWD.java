package Comp.EDJO_ASWD;

import java.util.Arrays;
import java.util.List;

public class EDJO_ASWD {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 12, 21, 31, 41, 51, 61, 71, 81, 91, 101, 211, 123, 456);
        /*numbers.stream().filter(num -> {
                    String numStr = String.valueOf(num);
                    return numStr.length() >= 2 && numStr.charAt(1) == '1';
                })
                .forEach(System.out::println);*/

        for (int num : numbers) {
            int absNum = Math.abs(num);
            if (absNum < 11) {
                continue;
            }

            // Find the number of digits
            int digitCount = (int) Math.log10(absNum) + 1;
            int divisor = (int) Math.pow(10, digitCount - 2);
            int secondDigit = (absNum / divisor) % 10;

            if (secondDigit == 1) {
                System.out.println(num);
            }
        }

    }
}

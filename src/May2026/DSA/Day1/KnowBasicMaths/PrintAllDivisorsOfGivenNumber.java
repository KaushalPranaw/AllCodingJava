package May2026.DSA.Day1.KnowBasicMaths;

import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisorsOfGivenNumber {
    public static void main(String[] args) {
        //Input: N = 36
        //Output: [1, 2, 3, 4, 6, 9, 12, 18, 36]
        //Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.
        int n = 36;
        System.out.println(getDivisors(n));

    }

    /*public static List<Integer> getDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;

    }*/
    public static List<Integer> getDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }
        return list;

    }
}

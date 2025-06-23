package Comp.GSGR_PMW3;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println(primeFactorization(6));   // Output: [2, 3]
        System.out.println(primeFactorization(5));   // Output: [5]
        System.out.println(primeFactorization(12));  // Output: [2, 2, 3]
    }

    /*private static List<Integer> primeFactorization(int num) {
        List<Integer> list = new ArrayList<>();

        //if divisible by 2
        while (num % 2 == 0) {
            list.add(2);
            num /= 2;
        }

        //check for odd num till square root
        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                list.add(i);
                num /= i;
            }
        }

        // If x is a prime number greater than 2, add it to the factors
        if (num > 2) {
            list.add(num);
        }
        return list;

    }*/

    private static List<Integer> primeFactorization(int num) {
        List<Integer> primes = new ArrayList<>();

        while (num % 2 == 0) {
            primes.add(2);
            num /= 2;
        }

        for (int i = 3; i * i < num; i = i + 2) {
            if (num % i == 0) {
                primes.add(i);
            }
        }
        if (num > 2) {
            primes.add(num);
        }
        return primes;

    }
}

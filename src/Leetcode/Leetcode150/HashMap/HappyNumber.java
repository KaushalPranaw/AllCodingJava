package Leetcode.Leetcode150.HashMap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(new HappyNumber().isHappy(n));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int cur = n;
            int sum = 0;
            while (cur != 0) {
                int rem = cur % 10;
                sum += rem * rem;
                cur /= 10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }
}

package DSA2026.D07_HashMap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        //Input: n = 19
        //Output: true
        //1 squre 2 + 9 squre 2 = 82
        //82 + 22 = 68
        //62 + 82 = 100
        //12 + 02 + 02 = 1
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
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
            }
            set.add(sum);
            n = sum;
        }
        return true;

    }
}

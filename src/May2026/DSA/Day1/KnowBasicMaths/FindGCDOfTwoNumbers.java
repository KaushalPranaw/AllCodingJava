package May2026.DSA.Day1.KnowBasicMaths;

public class FindGCDOfTwoNumbers {
    public static void main(String[] args) {
        //Input: N1 = 9, N2 = 12
        //Output: 3
        //means sbse bada num jo dono ko divide kr de
        int n1 = 9, n2 = 12;
        System.out.println(findGcd(n1, n2));

    }

    //brute
    /*public static int findGcd(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;

    }*/
    //better
    /*public static int findGcd(int n1, int n2) {
        for (int i = Math.min(n1, n2); i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }
        return 1;

    }*/

    public static int findGcd(int n1, int n2) {
        //To find the GCD of n1 and n2 where n1 > n2:
        //1. Repeatedly subtract the smaller number from the larger number until one of them becomes 0.
        //2. Once one becomes 0, the other is the GCD of the original numbers.
        //n1 = 20, n2 = 15
        //
        //gcd(20, 15) = gcd(20 - 15, 15) = gcd(5, 15)
        //gcd(5, 15)  = gcd(15 - 5, 5)  = gcd(10, 5)
        //gcd(10, 5)  = gcd(10 - 5, 5) = gcd(5, 5)
        //gcd(5, 5)   = gcd(5 - 5, 5)  = gcd(0, 5)
        //
        //Hence, return 5 as the GCD.

        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = n1 % n2;//20%15=20-15=5
            } else {
                n2 = n2 % n1;
            }
        }
        if (n1 == 0) {
            return n2;
        }
        return n1;

    }
}

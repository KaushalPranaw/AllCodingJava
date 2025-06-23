package Comp.GSGR_PMW3;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(isPowerOf10(3));    // false
        System.out.println(isPowerOf10(10));   // true
        System.out.println(isPowerOf10(100));  // true
        System.out.println(isPowerOf10(0));    // false
        System.out.println(isPowerOf10(1));    // true
    }

    /*private static boolean isPowerOf10(int num) {
        if (num < 1) {
            return false;
        }

        while (num % 10 == 0) {
            num = num / 10;
        }
        return num == 1;
    }*/

    private static boolean isPowerOf10(int num) {
        if (num < 1) {
            return false;
        }

        while (num % 10 == 0) {
            num /= 10;
        }
        return num == 1;
    }
}

package Comp.GSGR_PMW3;

public class Problem1 {
    public static void main(String[] args) {
        int[] fraction1 = {2, 3};
        int[] fraction2 = {1, 2};

        int[] result = addFractions(fraction1, fraction2);
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] addFractions(int[] fraction1, int[] fraction2) {
        int num1 = fraction1[0];
        int den1 = fraction1[1];
        int num2 = fraction2[0];
        int den2 = fraction2[1];

        int resNum = num1 * den2 + num2 * den1;
        int resDen = den1 * den2;
        int gcd = findGCD(resNum, resDen);

        return new int[]{resNum / gcd, resDen / gcd};
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /*public static int[] addFractions(int[] fraction1, int[] fraction2) {
        int num1 = fraction1[0];
        int den1 = fraction1[1];
        int num2 = fraction2[0];
        int den2 = fraction2[1];

        // Find common denominator
        int resNum = (num1 * den2 + num2 * den1);
        int resDen = (den1 * den2);

        // Step 2: Simplify using GCD
        int gcd = findGCD(resNum, resDen);

        // Step 3: Return simplified result
        return new int[]{resNum / gcd, resDen / gcd};


    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }*/
}

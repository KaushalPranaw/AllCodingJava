package DSA_RoadMap.Day1;

public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2,5));
    }

    public static double myPow(double base, int n) {
        long exp = n;

        if (exp == 0) {
            return 1;
        }
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;
        }

        double res = 1;
        while (exp != 0) {
            if (exp % 2 == 1) {
                //means odd number
                res = res * base;
            }
            base = base * base;
            exp = exp / 2;
        }
        return res;
    }
}

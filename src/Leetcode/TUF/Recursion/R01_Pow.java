package Leetcode.TUF.Recursion;

public class R01_Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 5));
    }

    /*private static double myPow(int x, int n) {
        double ans = 1.0;
        for (int i = 0; i < n; i++) {
            ans = ans * x;
        }
        return ans;
    }*/

    private static double myPow(int x, int n) {
        double ans = 1.0;
        for (int i = 0; i < n; i++) {
            ans = ans * x;
        }
        return ans;
    }

}

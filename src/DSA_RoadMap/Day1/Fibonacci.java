package DSA_RoadMap.Day1;

public class Fibonacci {
    public static void main(String[] args) {
        //0,1,1,2,3,5,8,13......
        int n = 6;
        System.out.println(fib(n));


    }

    /*public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);

    }*/

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = prev2 + prev1;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;

    }
}

package May2026.Day1.LearnBasicRecursion;

public class R04_SumOfFirstNNaturalNumbers {
    public static void main(String[] args) {
        //Input: N=5
        //Output: 15
        //Explanation: 1+2+3+4+5=15
        int n = 5;
        int sum=sumOfFirstNNaturalNumbers(n);
        System.out.println(sum);
    }

    //sum(N) = N + sum(N-1), with the base case sum(1) = 1.
    static int sumOfFirstNNaturalNumbers(int n) {
        if (n == 1) {
            return n;
        }
        return n + sumOfFirstNNaturalNumbers(n - 1);

    }

}

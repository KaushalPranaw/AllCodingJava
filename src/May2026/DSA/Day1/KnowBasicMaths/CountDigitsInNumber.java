package May2026.DSA.Day1.KnowBasicMaths;

public class CountDigitsInNumber {
    public static void main(String[] args) {
        int N = 12345;
        System.out.println(countDigitsInNumber(N));
    }

    /*private static int countDigitsInNumber(int n) {
        int count=0;
        while (n!=0){
            n=n/10;
            count++;
        }
        return count;
    }*/
    //using log
    private static int countDigitsInNumber(int n) {
        if(n==0) return 1;
        return (int)Math.log10(n)+1;

        /*
        log10(n) answers this:
        “10 ko kitni power deni padegi to get n?”

        Mathematically:
        log10(n) = x  ⇔  10^x = n

        🧠 Key Insight for Digits
        Any number can be written like this:

        1 digit → 1 to 9 → 10^0 to < 10^1
        2 digits → 10 to 99 → 10^1 to < 10^2
        3 digits → 100 to 999 → 10^2 to < 10^3

        👉 So:
        Number of digits = floor(log10(n)) + 1

        📌 Example 1: n = 12345
        log10(12345) ≈ 4.091

        Now:
        (int) 4.091 = 4
        4 + 1 = 5 digits ✅
         */
    }
}

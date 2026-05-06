package May2026.DSA.Day1.LearnBasicRecursion;

public class R02_Print1ToNUsingRecursion {
    public static void main(String[] args) {
        //Input: N = 4
        //Output: 1, 2, 3, 4
        //Explanation: All the numbers from 1 to 4 are printed.
        int n = 10;
        printNumbers(1, n);
    }

    private static void printNumbers(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println(i);
        printNumbers(i+1, n);
    }
}

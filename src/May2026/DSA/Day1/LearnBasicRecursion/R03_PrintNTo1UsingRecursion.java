package May2026.DSA.Day1.LearnBasicRecursion;

public class R03_PrintNTo1UsingRecursion {
    public static void main(String[] args) {
        //Input: N = 4
        //Output: 4, 3, 2, 1
        //Explanation: All the numbers from 4 to 1 are printed
        int n=10;
        print(n);
    }
    static void print(int n){
        if(n<1){
            return;
        }
        System.out.println(n);
        print(n-1);
    }
}

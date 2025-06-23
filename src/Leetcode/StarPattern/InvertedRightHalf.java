package Leetcode.StarPattern;

public class InvertedRightHalf {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            //print space;
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n + 1 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

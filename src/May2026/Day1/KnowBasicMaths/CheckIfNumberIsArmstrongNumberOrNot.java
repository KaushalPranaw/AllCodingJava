package May2026.Day1.KnowBasicMaths;

public class CheckIfNumberIsArmstrongNumberOrNot {
    public static void main(String[] args) {
        int N = 153;
        //Explanation: 1^3+5^3+3^3 = 1 + 125 + 27 = 153 so true
        System.out.println(isArmstrong(N));
    }

    public static boolean isArmstrong(int num) {
        int len = String.valueOf(num).length();
        int n = num;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, len);
            n = n / 10;
        }
        return sum == num;

    }
}

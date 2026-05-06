package May2026.DSA.Day1.KnowBasicMaths;

public class CheckIfNumberIsPrimeOrNot {
    public static void main(String[] args) {
        int n = 1483;  // Example number
        System.out.println(checkPrime(n));
    }
    /*public static boolean checkPrime(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        return count==2;
    }*/
    public static boolean checkPrime(int n) {
        int count=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                count++;

                // If n is not a perfect square, count its reciprocal factor
                if (n / i != i) {
                    count++;
                }
            }
        }
        return count==2;
    }
}

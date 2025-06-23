package Comp.GSGR_PMW3;

public class Problem2 {
    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {2, 3};

        long result = dotProduct(array1, array2);
        System.out.println("Result: " + result); // Expected output: 8
    }

    private static long dotProduct(int[] array1, int[] array2) {
        long sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += ((long) array1[i] * array2[i]);
        }
        return sum;
    }

    /*private static long dotProduct(int[] array1, int[] array2) {
        long res = 0;
        for (int i = 0; i < array1.length; i++) {
            res += ((long) array1[i] * array2[i]);
        }
        return res;
    }*/
}

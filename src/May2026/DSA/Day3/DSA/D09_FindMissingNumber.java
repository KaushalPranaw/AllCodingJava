package May2026.DSA.Day3.DSA;

import java.util.Arrays;

public class D09_FindMissingNumber {
    public static void main(String[] args) {
        //Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
        //Output: 6
        //Explanation: All the numbers from 1 to 8 are present except 6.
        //Input: arr[] = [1, 2, 3, 5]
        //Output: 4
        //Explanation: Here the size of the array is 4, so the range will be [1, 5]. The missing number between 1 to 5 is 4

        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNum(arr));
    }

    private static int missingNum(int[] arr) {
        int n = arr.length + 1;

        long sum = Arrays.stream(arr).sum();
        long expSum = (long) n * (n + 1) / 2;
        return (int) (expSum - sum);
    }
}

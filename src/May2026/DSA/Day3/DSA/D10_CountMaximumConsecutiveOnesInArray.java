package May2026.DSA.Day3.DSA;

public class D10_CountMaximumConsecutiveOnesInArray {
    public static void main(String[] args) {
        //Example 1:
        //Input: prices = {1, 1, 0, 1, 1, 1}
        //Output: 3
        //Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.
        int[] arr = {1, 1, 0, 1, 1, 1};

        int result = findMaxConsecutiveOnes(arr);

        System.out.println("Maximum consecutive ones: " + result);
    }

    private static int findMaxConsecutiveOnes(int[] arr) {
        int count = 0;
        int maxCount = 0;
        for (int num : arr) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}

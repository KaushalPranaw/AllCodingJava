package DSA2026.D04_TwoPointers;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        //Input: numbers = [2,7,11,15], target = 9
        //Output: [1,2]

        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[0];
    }
}

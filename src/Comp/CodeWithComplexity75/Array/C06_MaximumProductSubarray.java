package Comp.CodeWithComplexity75.Array;

public class C06_MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new C06_MaximumProductSubarray().maxProduct(nums));
    }

    /*
    maxSoFar
    maxAtCurrentIndex
    minAtCurrentIndex
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            // Swap if current number is negative
            if (current < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(current, current * maxEndingHere);
            minEndingHere = Math.min(current, current * minEndingHere);

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}

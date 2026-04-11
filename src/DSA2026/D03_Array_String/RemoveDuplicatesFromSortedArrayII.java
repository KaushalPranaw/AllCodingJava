package DSA2026.D03_Array_String;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        //Input: nums = [0,0,1,1,1,1,2,3,3]
        //Output: 7, nums = [0,0,1,1,2,3,3,_,_]
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            if (unique < 2 || nums[unique-2] < num) {
                nums[unique] = num;
                unique++;
            }
        }
        return unique;
    }
}

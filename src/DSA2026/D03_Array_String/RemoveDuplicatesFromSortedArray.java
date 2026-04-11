package DSA2026.D03_Array_String;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        //Input: nums = [0,0,1,1,1,2,2,3,3,4]
        //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int unique = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[unique] != nums[i]) {
                unique++;
                nums[unique] = nums[i];
            }
        }
        return unique + 1;
    }
}

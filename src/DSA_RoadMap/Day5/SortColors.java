package DSA_RoadMap.Day5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        /*
        We traverse using mid:

        If nums[mid] == 0 → swap with nums[low], move both forward

        If nums[mid] == 1 → just move mid forward

        If nums[mid] == 2 → swap with nums[high], move high backward (but don’t move mid yet)
         */
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int t = nums[mid];
                nums[mid] = nums[low];
                nums[low] = t;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int t = nums[mid];
                nums[mid] = nums[high];
                nums[high] = t;
                high--;
            }

        }

    }
}

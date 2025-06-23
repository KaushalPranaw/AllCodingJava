package Comp.CodeWithComplexity75.Array;

public class C07_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(new C07_FindMinimumInRotatedSortedArray().findMin(nums));
    }

    /*
    3, 4, 5, 1, 2
    l     m      r
     */
    //kul mila ke hume shorted found krna h
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}

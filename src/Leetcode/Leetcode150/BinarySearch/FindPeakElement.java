package Leetcode.Leetcode150.BinarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        /*
         *
         *                     m=3
         *                     nums[m]=3
         *                     nums[m+1]=5
         * */
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }

    //1,2,1,3,5,6,4
    /*
     *             1,2,1,3,5,6,4
     *                   m
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

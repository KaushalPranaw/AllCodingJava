package Leetcode.BinarySearch;

import DesignPatterns.Structural.Decorator.MilkDecorator;

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
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                //mtlb peak element left side hoga ya fir mid hi hoga
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

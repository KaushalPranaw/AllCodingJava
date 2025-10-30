package Leetcode.Leetcode150.BinarySearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

        // Test cases
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Test Case 1: nums = {4, 5, 6, 7, 0, 1, 2}, target = 0, Result: " + solution.search(nums1, target1)); // Expected: 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Test Case 2: nums = {4, 5, 6, 7, 0, 1, 2}, target = 3, Result: " + solution.search(nums2, target2)); // Expected: -1

    }

    //The array is sorted but rotated — meaning one half is always sorted.
    //For any mid you check:
    //Either left half (low to mid) is sorted, or
    //Right half (mid to high) is sorted.

    //Set low = 0 and high = nums.length - 1
    //While low <= high:
    //Find mid = (low + high) / 2.
    //If nums[mid] == target, return mid (found it!).
    //Decide which half is sorted:

    //If nums[low] <= nums[mid], left side is sorted
    //Check if target lies between nums[low] and nums[mid]
    //If yes, move high = mid - 1.
    //Else, move low = mid + 1

    //Else, right side is sorted:
    //Check if target lies between nums[mid] and nums[high]:
    //If yes, move low = mid + 1.
    //Else, move high = mid - 1.
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                //if left half is sorted
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    //right half is sorted
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

}

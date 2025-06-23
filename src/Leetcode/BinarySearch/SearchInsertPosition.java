package Leetcode.BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        // Test cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Test Case 1: nums = {1, 3, 5, 6}, target = 5, Result: " + solution.searchInsert(nums1, target1)); // Expected: 2

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Test Case 2: nums = {1, 3, 5, 6}, target = 2, Result: " + solution.searchInsert(nums2, target2)); // Expected: 1

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Test Case 3: nums = {1, 3, 5, 6}, target = 7, Result: " + solution.searchInsert(nums3, target3)); // Expected: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Test Case 4: nums = {1, 3, 5, 6}, target = 0, Result: " + solution.searchInsert(nums4, target4)); // Expected: 0

        int[] nums5 = {1};
        int target5 = 0;
        System.out.println("Test Case 5: nums = {1}, target = 0, Result: " + solution.searchInsert(nums5, target5)); // Expected: 0

        int[] nums6 = {1};
        int target6 = 2;
        System.out.println("Test Case 6: nums = {1}, target = 2, Result: " + solution.searchInsert(nums6, target6)); // Expected: 1

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target7 = 6;
        System.out.println("Test Case 7: nums = {1,2,3,4,5,6,7,8,9,10}, target = 6, Result: " + solution.searchInsert(nums7, target7)); // Expected: 5

        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target8 = 11;
        System.out.println("Test Case 8: nums = {1,2,3,4,5,6,7,8,9,10}, target = 11, Result: " + solution.searchInsert(nums8, target8)); // Expected: 10

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target9 = 0;
        System.out.println("Test Case 9: nums = {1,2,3,4,5,6,7,8,9,10}, target = 0, Result: " + solution.searchInsert(nums9, target9)); // Expected: 0

    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

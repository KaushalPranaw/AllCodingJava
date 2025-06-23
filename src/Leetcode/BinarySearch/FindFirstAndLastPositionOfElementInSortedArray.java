package Leetcode.BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();

        // Test cases
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Test Case 1: nums = {5, 7, 7, 8, 8, 10}, target = 8, Result: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [3, 4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("Test Case 2: nums = {5, 7, 7, 8, 8, 10}, target = 6, Result: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [-1, -1]

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }

        res[0] = findFirsts(nums, target);
        res[1] = findSecond(nums, target);
        return res;
    }

    private int findFirsts(int[] nums, int target) {
        int res = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private int findSecond(int[] nums, int target) {
        int res = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}

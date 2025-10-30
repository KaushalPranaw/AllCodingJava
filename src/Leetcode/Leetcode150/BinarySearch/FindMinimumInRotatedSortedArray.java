package Leetcode.Leetcode150.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();

        // Test cases
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test Case 1: nums = {3, 4, 5, 1, 2}, Result: " + solution.findMin(nums1)); // Expected: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Test Case 2: nums = {4, 5, 6, 7, 0, 1, 2}, Result: " + solution.findMin(nums2)); // Expected: 0

    }
    /*
    If the array was not rotated, the first element would be the smallest.
    But because of rotation, the smallest element is where the rotation happened

    Important point : In a rotated array, the minimum element is the only element
    which is smaller than its previous element.

    Set low = 0, high = nums.length - 1.
    find mid
    Check if mid is in the rotated part or sorted part

    If nums[mid] > nums[high], the minimum must be to the right of mid,
    so do low = mid + 1.

    Else (nums[mid] <= nums[high]), the minimum is at mid or to the left,
    so do high = mid.

    When low == high, nums[low] is the minimum.

    If nums[mid] > nums[high],
    it means the smallest value is further right (because rotation is after mid)
    5,1,2,3,4
    mid=0, high=4

    If nums[mid] <= nums[high], it means the smallest value is at mid or before
    5,1,2,3,4
    mid=2, high=4

     */
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        int low=0, high=nums.length-1;
        while (low<high){
            int mid=low+(high-low)/2;

            //now check if mid bada hai high se
            //mtlb small aagehi hoga fir to
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else {
                //mtlb mid<=high
                //to min ya to mid hoga ya fir left side
                high=mid;
            }
            //jab dono barabar hoge to loop khtm ho jayega
            //means low==high
        }
        return nums[low];
    }
}

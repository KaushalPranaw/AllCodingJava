package May2026.DSA.Day3.DSA;

public class D05_LeftRotateArrayByOne {
    public static void main(String[] args) {
        //Input:
        // nums = [-1, 0, 3, 6]
        //Output:
        // [0, 3, 6, -1]
        //Explanation:
        // Initially, nums = [-1, 0, 3, 6]
        //Rotating once to the left results in nums = [0, 3, 6, -1].
        int[] nums = {1, 2, 3, 4, 5};

        rotateArrayByOne(nums);

        // Output the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void rotateArrayByOne(int[] nums) {
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = first;
    }
}

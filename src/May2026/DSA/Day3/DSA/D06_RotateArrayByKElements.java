package May2026.DSA.Day3.DSA;

public class D06_RotateArrayByKElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        String direction = "right";

        // Call rotateArray and store result
        int[] result = rotateArray(nums, k, direction);

        // Print rotated array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static int[] rotateArray(int[] nums, int k, String direction) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return nums;
        }

        k = k % n;
        if (direction.equals("right")) {
            //reverse all
            reverse(nums, 0, n - 1);
            //reverse k
            reverse(nums, 0, k - 1);
            //reverse remaining (n-k)
            reverse(nums, k, n - 1);
        } else if (direction.equals("left")) {
            //1, 2, 3, 4, 5, 6, 7
            // Step 1: reverse first k elements
            reverse(nums, 0, k - 1);
            //2, 1, 3, 4, 5, 6, 7

            // Step 2: reverse remaining n-k elements
            reverse(nums, k, n - 1);
            //2, 1, 7, 6, 5, 4, 3

            // Step 3: reverse entire array
            reverse(nums, 0, n - 1);
            //3,4,5,6,7,1,2
        }
        return nums;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}

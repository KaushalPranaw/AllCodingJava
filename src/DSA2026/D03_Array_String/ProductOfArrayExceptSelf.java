package DSA2026.D03_Array_String;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        //Input: nums = [1,2,3,4]
        //Output: [24,12,8,6]
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int lp = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = lp;
            lp = lp * nums[i];
        }

        int rp = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * rp;
            rp = rp * nums[i];
        }
        return ans;
    }
}

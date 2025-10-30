package Leetcode.Leetcode150.Array_String;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        //1,1,2,6
        //pa=1*4*3*2
        //24,12,8,6
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));

    }
    //1,2,3,4
    //1,1,2,6
    //pa=4
    //6

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int pa = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * pa;
            pa = pa * nums[i];
        }

        return ans;
    }
}

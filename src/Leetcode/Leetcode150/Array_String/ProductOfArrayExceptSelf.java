package Leetcode.Leetcode150.Array_String;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        //1,1,2,6
        //pa=12
        //res[i]=pa*res[i];
        //pa=pa*nums[i];
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
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int pa = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = pa * ans[i];
            pa = pa * nums[i];
        }
        return ans;
    }
}

package Comp.CodeWithComplexity75.Array;

import java.util.Arrays;

public class C04_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new C04_ProductOfArrayExceptSelf().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        /*
        1 2 3 4
        1 1 2 6


         */
        //l->r
        ans[0] = 1;
        //ans[i]=ans[i-1]*nums[i-1]
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        //r->l
        int pa = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * pa;
            pa = pa * nums[i];
        }
        return ans;
    }
}

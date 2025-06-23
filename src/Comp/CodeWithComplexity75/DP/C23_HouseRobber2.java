package Comp.CodeWithComplexity75.DP;

public class C23_HouseRobber2 {
    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};

        int n = arr.length;
        int t1[] = new int[n - 1];
        int t2[] = new int[n - 1];

        int k1 = 0, k2 = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                t1[k1++] = arr[i];
            }

            if (i != n - 1) {
                t2[k2++] = arr[i];
            }
        }
        C23_HouseRobber2 obj = new C23_HouseRobber2();
        int result = Math.max(obj.rob(t1), obj.rob(t2));
        System.out.println(result);
    }

    /*//recur+memo
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, nums, dp);
    }

    private int helper(int ind, int[] nums, int[] dp) {
        if (ind == 0) {
            return nums[ind];
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        if (ind < 0) {
            return 0;
        }

        int skip = helper(ind - 1, nums, dp);
        int take = nums[ind] + helper(ind - 2, nums, dp);
        return dp[ind] = Math.max(skip, take);
    }*/

    /*//tab
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;          // No houses to rob
        if (n == 1) return nums[0];    // Only one house to rob

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int ind = 2; ind < n; ind++) {
            int skip = dp[ind - 1];
            int take = 0;
            take = nums[ind] + dp[ind - 2];

            dp[ind] = Math.max(skip, take);
        }
        return dp[n - 1];
    }*/

    //tab
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;          // No houses to rob
        if (n == 1) return nums[0];    // Only one house to rob

        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int ind = 2; ind < n; ind++) {
            int skip = prev;
            int take = nums[ind] + prev2;

            int cur = Math.max(skip, take);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

}

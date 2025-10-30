package Leetcode.Leetcode150.Array_String;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 2, 0, 4};
        System.out.println(new JumpGame().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (maxReachable >= n - 1) {
                return true;
            }
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return false;
    }

    //bottom-up
    /*public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //dp[i] is reachable or not
                if (dp[j] == true && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }*/

    //recur+memo
    /*public boolean canJump(int[] nums) {
        int i = 0;
        boolean[] dp = new boolean[nums.length + 1];
        return helper(i, nums, dp);
    }

    boolean helper(int index, int[] nums, boolean[] dp) {
        //base case
        if (index >= nums.length - 1) {
            return true;
        }
        if (dp[index] != false) {
            return dp[index];
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (helper(index + i, nums, dp)) {
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }*/
}

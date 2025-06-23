package Comp.CodeWithComplexity75.DP;

public class C24_JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        C24_JumpGame o = new C24_JumpGame();
        System.out.println(o.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable) {
                return false;
            }

            if (maxReachable >= nums.length - 1) {
                return true;
            }

            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return false;
    }
}

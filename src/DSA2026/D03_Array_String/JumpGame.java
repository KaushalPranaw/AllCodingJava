package DSA2026.D03_Array_String;

public class JumpGame {
    public static void main(String[] args) {
        //Input: nums = [2,3,1,1,4]
        //Output: true
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;
        for (int i = 0; i < n; i++) {
            //no need to check this
            /*if (maxReachable >= n - 1) {
                return true;
            }*/
            if (maxReachable < i) {
                return false;
            }
            maxReachable = Math.max(i + nums[i], maxReachable);
        }
        return true;
    }
}

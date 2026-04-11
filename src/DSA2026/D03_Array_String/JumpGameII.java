package DSA2026.D03_Array_String;

public class JumpGameII {
    public static void main(String[] args) {
        //Input: nums = [2,3,1,1,4]
        //Output: 2
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int minJump = 0;
        int l = 0, r = 0;
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            minJump++;
        }
        return minJump;
    }
}

package DSA2026.D01_BitMath;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            temp=temp^nums[i];
        }
        return temp;
    }
}

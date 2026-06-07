package Leetcode.Leetcode150.Array_String;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));

    }

    public int majorityElement(int[] nums) {
        int count=0;
        int candiate=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candiate){
                count++;
            }else {
                count--;
            }

            if(count<0){
                count=0;
                candiate=nums[i];
            }
        }
        return candiate;
    }
}

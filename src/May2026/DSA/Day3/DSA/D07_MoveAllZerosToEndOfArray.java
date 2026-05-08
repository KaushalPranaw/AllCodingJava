package May2026.DSA.Day3.DSA;

public class D07_MoveAllZerosToEndOfArray {
    public static void main(String[] args) {
        //Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
        //Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        // Print the result
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    private static void moveZeroes(int[] nums) {
        //find non-zero element and swap at jth index and increment j
        int j=0;//position for non-zero element
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}

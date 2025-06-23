package Leetcode.Auto.Premium;

public class SegregateZerosAndOnes {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        segregate(arr1);
        System.out.println(java.util.Arrays.toString(arr1)); // Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

    }
    public static void segregate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // Handle empty or null array
        }

        int left=0, right=arr.length-1;
        while (left<right){
            while (left<right && arr[left]==0){
                left++;
            }

            while (left<right && arr[right]==1){
                right--;
            }

            if(left<right){
                int t=arr[left];
                arr[left]=arr[right];
                arr[right]=t;
                left++;
                right--;
            }
        }
    }
}

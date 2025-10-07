package DSA_RoadMap.Day5;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        //https://leetcode.com/problems/sort-an-array/description/
        int[] nums = {5, 2, 3, 1};
        System.out.println(Arrays.toString(new SortAnArray().sortArray(nums)));
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l>=r){
            return;
        }

        int m=l+(r-l)/2;
        // Sort left and right halves
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        // Merge the sorted halves
        mergeA(nums, l, m, r);
    }

    private void mergeA(int[] nums, int l, int m, int r) {
        int temp[]=new int[r-l+1];
        int i=l, j=m+1, k=0;
        while (i<=m && j<=r){
            if(nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else {
                temp[k++]=nums[j++];
            }
        }
        while (i<=m){
            temp[k++]=nums[i++];
        }

        while (j<=r){
            temp[k++]=nums[j++];
        }
        for(int p=0;p<temp.length;p++){
            nums[l+p]=temp[p];
        }
    }
}

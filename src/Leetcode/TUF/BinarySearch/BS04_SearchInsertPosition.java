package Leetcode.TUF.BinarySearch;

public class BS04_SearchInsertPosition {
    //same as lower bound
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 2;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);
    }

    private static int searchInsert(int[] arr, int x) {
        int low=0, high=arr.length-1;
        int ans=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return ans;
    }
}

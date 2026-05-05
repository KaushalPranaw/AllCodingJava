package Comp.Crisil;

public class BinarySearchUsingRecur {
    public static void main(String[] args) {
        int target = 5;
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchUsingRecur(arr, target));
    }

    static int binarySearchUsingRecur(int[] arr, int target){
        int low=0;
        int high=arr.length-1;
        return helper(arr, low, high, target);
    }

    private static int helper(int[] arr, int low, int high, int target) {
        if(low>high){
            return -1;
        }

        int mid=low+(high-low)/2;

        if(arr[mid]==target){
            return mid;
        } else if(arr[mid]>target){
            high=mid-1;
            return helper(arr, low, high, target);
        }else{
            low=mid+1;
            return helper(arr, low, high, target);
        }
    }
}

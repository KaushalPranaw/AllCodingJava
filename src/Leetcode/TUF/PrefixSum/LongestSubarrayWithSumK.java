package Leetcode.TUF.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 6;

        int result = longestSubarrayWithSumK(arr, k);

        System.out.println("Longest Subarray Length: " + result);
    }

    /*public static int longestSubarrayWithSumK(int[] arr, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int maxLen=0, sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            if(sum==k){
                //first time aya h avi
                maxLen=Math.max(maxLen, i+1);
            }

            //calculate remainig anf check in map if phle se hai remaining
            //to hum dekh skte hai
            int remaining=sum-k;
            if(map.containsKey(remaining)){
                //cal leng
                int len=i-map.get(remaining);
                maxLen=Math.max(maxLen, len);
            }

            //it is needed for zero and negative case so checking
            //update map if not exist
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxLen;
    }*/

    //if having only positive - 2 pointer is the optmial sol
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int left = 0, right = 0;
        int sum = arr[0];
        int maxLen = 0;
        int n = arr.length;
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) {
                sum += arr[right];
            }
        }
        return maxLen;
    }
}

package May2026.DSA.Day3.DSA;

import java.util.HashMap;
import java.util.Map;

public class D13_LengthOfLongestSubarrayWithZeroSum {
    public static void main(String[] args) {
        //Input:
        // N = 6, array[] = {9, -3, 3, -1, 6, -5}
        //Result:
        // 5
        int[] arr = {9, -3, 3, -1, 6, -5};

        int ans = longestZeroSumSubarray(arr);

        System.out.println("Longest Zero Sum Subarray Length: " + ans);
    }

    private static int longestZeroSumSubarray(int[] arr) {
        // prefixSum -> first index
        Map<Integer, Integer> map=new HashMap<>();

        int prefixSum=0;
        int maxLen=0;

        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            // Case 1: If prefixSum becomes 0
            if(prefixSum==0){
                maxLen=i+1;
            }
            // Case 2: prefixSum already exists
            if(map.containsKey(prefixSum)){
                int len=i-map.get(prefixSum);
                maxLen=Math.max(maxLen, len);
            }else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;

    }
}

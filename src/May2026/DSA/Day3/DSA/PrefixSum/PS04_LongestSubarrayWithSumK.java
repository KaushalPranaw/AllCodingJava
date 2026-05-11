package May2026.DSA.Day3.DSA.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class PS04_LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,-1,5,-2,3};
        int k = 3;
        System.out.println(longestSubarrayWithSumK(arr, k));//output: 4
    }

    private static int longestSubarrayWithSumK(int[] arr, int k) {
        int n=arr.length;

        int currentPrefixSum=0;
        int maxLength=0;
        //create a map to store the first occurrence of each prefix sum
        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            currentPrefixSum += arr[i];

            // Case 1: If prefixSum equals k, update maxLength
            if(currentPrefixSum==k){
                maxLength=i+1;// first time we get prefixSum=k
            }
            //checking agar phle kahi mila hai to uska index nikal ke current index se minus karenge to hume milega length
            int oldPrefixSum=currentPrefixSum-k;
            if(map.containsKey(oldPrefixSum)){
                int currentLength=i-map.get(oldPrefixSum);
                maxLength=Math.max(maxLength, currentLength);
            }
            // Case 2: If prefixSum is not already in the map, add it with its index
            if(!map.containsKey(currentPrefixSum)){
                map.put(currentPrefixSum, i);// store the first occurrence of this prefix sum
            }
        }

        return maxLength;
    }
}

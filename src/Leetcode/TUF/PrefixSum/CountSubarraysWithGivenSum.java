package Leetcode.TUF.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        int k = 5;

        int result = findAllSubarraysWithGivenSum(arr, k);

        System.out.println("Count of Subarrays with sum " + k + " : " + result);
    }

    /*private static int findAllSubarraysWithGivenSum(int[] arr, int k) {
        //map to store prefixSum and their occurence
        Map<Integer, Integer> map = new HashMap<>();

        // means 0 occured once, since not taken any element yet
        map.put(0, 1);


        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int remaining = prefixSum - k;
            if (map.containsKey(remaining)) {
                count += map.get(remaining);
            }
            // Always update map
            //How many times each prefixSum has occurred so far
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        }
        return count;
    }*/

    private static int findAllSubarraysWithGivenSum(int[] arr, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);

        int count=0;
        int prefixSum=0;

        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            int remaining=prefixSum-k;
            if(map.containsKey(remaining)){
                int getRemainingCount=map.get(remaining);
                count+=getRemainingCount;
            }

            //update or insert into map the prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}

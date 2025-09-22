package Leetcode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArrayEqualsToK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        int k = 3;
        System.out.println(countOfSubArrayEqualsToK(arr, k));
    }

    private static int countOfSubArrayEqualsToK(int[] arr, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        //means prefix sum equal to zero have one occurence
        prefixSumMap.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }

            //update map
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;


    }
}

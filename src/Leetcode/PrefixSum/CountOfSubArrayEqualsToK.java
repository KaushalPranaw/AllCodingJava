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
        //map<prefixSum, count>
        Map<Integer, Integer> map = new HashMap<>();
        //means prefix sum equal to zero have one occurence
        map.put(0, 1);

        int count = 0;
        int currentPrefixSum = 0;
        for (int num : arr) {
            currentPrefixSum += num;

            //update count for (currentPrefix-k)=oldPrefix agar hai to update count
            count += map.getOrDefault(currentPrefixSum-k, 0);
            //update map
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }
        return count;


    }
}

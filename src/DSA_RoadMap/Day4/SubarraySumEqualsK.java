package DSA_RoadMap.Day4;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        int k = 3;
        System.out.println(subArrayEqualsToK(arr, k));
    }

    private static int subArrayEqualsToK(int[] arr, int k) {
        //prefix map
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

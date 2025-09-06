package SubArray.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayEqualToK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int k = 3;
        System.out.println(countSubArrEqToK(a, k));
    }

    private static int countSubArrEqToK(int[] a, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        //in presum we are storing sum and its count
        //since sum=0 and occurence is 1 so base case will be
        prefixSumMap.put(0, 1);
        int sum = 0, count = 0;
        //count is final count we got as answer


        for (int num : a) {
            sum += num;
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

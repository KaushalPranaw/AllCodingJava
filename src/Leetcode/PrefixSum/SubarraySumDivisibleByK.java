package Leetcode.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {

        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(new SubarraySumDivisibleByK().subarraysDivByK(nums, k));

    }

    /*
    For Sum = K problem, we used:
    currentPrefix - oldPrefix = k

    For Divisible by K problem, we use:
    (currentPrefix - oldPrefix) % k = 0

    Which means:
    currentPrefix % k
    =
    oldPrefix % k

    If:
    prefix1 % k == prefix2 % k
    then:
    (prefix2 - prefix1) % k == 0


    Instead of:
    Map<PrefixSum, Count>

    we store:
    Map<Remainder, Count>
     */
    /*public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1);

        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;

            int rem = ((prefixSum % k) + k) % k;// handle negative remainders
            count += remainderMap.getOrDefault(rem, 0);
            remainderMap.put(rem, remainderMap.getOrDefault(rem, 0) + 1);
        }

        return count;


    }*/

    public int subarraysDivByK(int[] nums, int k) {
        //map<remainder, count>
        Map<Integer, Integer> map=new HashMap<>();

        map.put(0, 1);
        int prefixSum=0;
        int count=0;

        for(int num: nums){
            prefixSum+=num;

            int rem=((prefixSum % k) + k) % k;
            count+=map.getOrDefault(rem, 0);
            //update map
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        return count;
    }
}
package Leetcode.Leetcode150.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    /*
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
    Therefore its length is 4.
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }

        Set<Integer> set=new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int longest=1;
        for(int num: nums){
            if(!set.contains(num-1)){
                int cur=num;
                int curStreak=1;
                while (set.contains(cur+1)){
                    curStreak++;
                    cur++;
                }
                longest= Math.max(longest, curStreak);
            }
        }
        return longest;
    }
}

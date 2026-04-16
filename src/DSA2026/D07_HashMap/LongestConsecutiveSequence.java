package DSA2026.D07_HashMap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //Input: nums = [100,4,200,1,3,2]
        //Output: 4
        //Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        Set<Integer> set=new HashSet<>();
        // Step 1: Add all elements to set
        for(int num: nums){
            set.add(num);
        }

        int maxLen=0;

        // Step 2: Iterate over set
        for(int num: set){
            // Only start if it's the beginning of a sequence
            if(!set.contains(num-1)){
                int cur=num;
                int curLen=1;

                // Expand forward
                while (set.contains(cur+1)){
                    cur++;
                    curLen++;
                }
                maxLen=Math.max(maxLen, curLen);
            }
        }

        return maxLen;

        
    }
}

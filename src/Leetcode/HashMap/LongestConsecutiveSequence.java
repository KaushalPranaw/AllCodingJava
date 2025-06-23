package Leetcode.HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = Arrays.stream(nums)
                .boxed().collect(Collectors.toSet());

        int longest = 1;
        for (int num : nums) {
            int curNum = num;
            int curStreak = 1;

            if (!set.contains(curNum - 1)) {
                while (set.contains(curNum + 1)) {
                    curStreak++;
                    curNum++;
                }
            }
            longest = Math.max(longest, curStreak);

        }
        return longest;
    }
}

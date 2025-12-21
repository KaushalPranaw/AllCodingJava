package Leetcode.Leetcode150.Intervals;

import CoreJava.OOPS.pillars.inheritance.A;

import java.util.ArrayList;
import java.util.List;

/*
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
*/
public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //check if cur is not consequetive
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + nums[i - 1]);
                }
                //update start
                start = nums[i];
            }
        }
        if (start == nums[nums.length - 1]) {
            list.add(String.valueOf(start));
        } else {
            list.add(start + "->" + nums[nums.length - 1]);
        }
        return list;
    }
}

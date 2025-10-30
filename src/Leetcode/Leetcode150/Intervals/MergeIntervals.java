package Leetcode.Leetcode150.Intervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervalMerge = new MergeIntervals().merge(intervals);
        System.out.println(Arrays.deepToString(intervalMerge));
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] currentInterval = intervals[0];
        list.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                currentEnd = Math.max(currentEnd, nextEnd);
                currentInterval[1] = currentEnd;
            } else {
                currentInterval = intervals[i];
                list.add(currentInterval);
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}

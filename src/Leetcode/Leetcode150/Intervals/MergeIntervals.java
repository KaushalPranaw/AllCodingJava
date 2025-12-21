package Leetcode.Leetcode150.Intervals;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervalMerge = new MergeIntervals().merge(intervals);
        System.out.println(Arrays.deepToString(intervalMerge));
    }

    public int[][] merge(int[][] intervals) {
        //Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergeList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergeList.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int ns = intervals[i][0];
            int ne = intervals[i][1];
            if (currentInterval[1] >= ns) {
                currentInterval[1] = Math.max(currentInterval[1], ne);
            } else {
                currentInterval = intervals[i];
                mergeList.add(currentInterval);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);

    }
}

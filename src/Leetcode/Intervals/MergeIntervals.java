package Leetcode.Intervals;

import java.lang.management.LockInfo;
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervalMerge = new MergeIntervals().merge(intervals);
        System.out.println(Arrays.deepToString(intervalMerge));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();

        int[] currentInterval = intervals[0];
        list.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int ce = currentInterval[1];
            int ns = intervals[i][0];
            int ne = intervals[i][1];
            if (ce >= ns) {
                currentInterval[1] = Math.max(ce, ne);
            } else {
                currentInterval = intervals[i];
                list.add(currentInterval);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}

package DSA2026.D08_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        //Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        //Output: [[1,6],[8,10],[15,18]]
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] interval : merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] currentInterval = intervals[0];
        list.add(currentInterval);
        for (int i = 1; i < intervals.length; i++) {
            int ce = currentInterval[1];
            int ns = intervals[i][0];
            int ne = intervals[i][1];
            if (ce >= ns) {
                //means we need to merge
                currentInterval[1] = Math.max(ce, ne);
            } else {
                currentInterval = intervals[i];
                list.add(currentInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

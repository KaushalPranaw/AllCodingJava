package DSA_RoadMap.Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        //Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();

        int[] currentInterval = intervals[0];
        list.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int ce = currentInterval[1];
            int ns = intervals[i][0];
            int ne = intervals[i][1];
            if (ns <= ce) {
                currentInterval[1] = Math.max(ne, ce);
            } else {
                currentInterval = intervals[i];
                list.add(currentInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

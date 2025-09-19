package Leetcode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {4, 6};

        int[][] merged = new InsertInterval().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(merged));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list=new ArrayList<>();
        int i=0;

        //insert phle ke
        while (i<intervals.length && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        //merge
        while (i<intervals.length && intervals[i][0]<= newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        //remaining
        while (i<intervals.length){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);

    }
}

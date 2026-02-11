package Leetcode.Leetcode150.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9},{10,15}};
        int[] newInterval = {4, 6};

        int[][] merged = new InsertInterval().insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(merged));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> list=new ArrayList<>();

        int i=0;
        //chota wala dal do
        while (i<intervals.length && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        //merge wala
        //intervals[i][0] <= newInterval[1]) - think and remember this point
        while (i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        //bade wale
        while (i<intervals.length){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);

    }
}

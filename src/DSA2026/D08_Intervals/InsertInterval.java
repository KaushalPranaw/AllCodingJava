package DSA2026.D08_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        //Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        //Output: [[1,5],[6,9]]
        // Input
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        // Call function
        int[][] result = insert(intervals, newInterval);

        // Print output
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }

    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        int i=0;
        //phle chote wale add kr do list me
        while (i<intervals.length && newInterval[0]>intervals[i][1]){
            list.add(intervals[i]);
            i++;
        }

        //fir merge wale dekh lo
        while (i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        //fir remaining jo bade hai
        while (i<intervals.length){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);

    }
}

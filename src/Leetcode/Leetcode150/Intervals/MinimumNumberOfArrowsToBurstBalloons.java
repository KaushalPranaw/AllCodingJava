package Leetcode.Leetcode150.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 9}};
        MinimumNumberOfArrowsToBurstBalloons obj = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(obj.findMinArrowShots(points));//2
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int arrow = 1;
        int minEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (minEnd >= points[i][0]) {
                //why min?
                //{1,6}, {2,8}, {7,12}, {10,16}
                //end=min(6, 8)=6
                //so one array can shot only 2 points
                //isiliye min lena hoga
                minEnd = Math.min(minEnd, points[i][1]);
            } else {
                arrow++;
                minEnd = points[i][1];
            }
        }
        return arrow;

    }
}

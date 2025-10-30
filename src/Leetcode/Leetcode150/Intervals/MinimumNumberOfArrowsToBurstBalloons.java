package Leetcode.Leetcode150.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        MinimumNumberOfArrowsToBurstBalloons obj = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(obj.findMinArrowShots(points));//2
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int count = 1; //atleast one arrow is needed
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                //why min?
                //{1,6}, {2,8}, {7,12}, {10,16}
                //end=min(6, 8)=6
                //so one array can shot only 2 points
                //isiliye min lena hoga
                end = Math.min(end, points[i][1]);
            } else {
                count++;
                end = points[i][1];
            }
        }
        return count;

    }
}

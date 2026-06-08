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

        int count = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                end = Math.min(end, points[i][1]);
            } else {
                count++;
                end=points[i][1];
            }
        }

        return count;


    }
}

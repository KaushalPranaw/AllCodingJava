package Leetcode.Intervals;

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

        Arrays.sort(points, Comparator.comparingInt(a->a[0]));

        int count = 1;
        int curEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (curEnd >= points[i][0]) {
                curEnd = Math.min(curEnd, points[i][1]);
            } else {
                count++;
                curEnd = points[i][1];
            }
        }
        return count;

    }
}

package DSA2026.D08_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        //Input: points = [[10,16],[2,8],[1,6],[7,12]]
        //Output: 2
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));

    }

    public static int findMinArrowShots(int[][] points) {
        //{{10, 16}, {2, 8}, {1, 6}, {7, 12}}
        Arrays.sort(points, Comparator.comparing(a -> a[0]));
        //{{1, 6}, {2, 8},  {7, 12},{10, 16}};

        int minArrow = 1;//min ek to lgna hi hai
        int currentEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (currentEnd >= points[i][0]) {
                //means overlapping
                currentEnd = Math.min(currentEnd, points[i][1]);
                //chota isliye kyuki utne hi fod payega ek bar me
                //why min?
                //{1,6}, {2,8}, {7,12}, {10,16}
                //end=min(6, 8)=6
                //so one array can shot only 2 points
                //isiliye min lena hoga
            } else {
                minArrow++;
                currentEnd=points[i][1];
            }
        }
        return minArrow;


    }
}

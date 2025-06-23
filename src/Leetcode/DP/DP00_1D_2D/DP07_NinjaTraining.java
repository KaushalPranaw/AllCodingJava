package Leetcode.DP.DP00_1D_2D;

import java.util.Arrays;

//https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
public class DP07_NinjaTraining {
    public static void main(String[] args) {
        // Define the points for each activity on each day
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points));
    }

    //recur+memo
    /*private static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return ninjaTrainingHelper(n - 1, 3, points, dp);
    }

    private static int ninjaTrainingHelper(int day, int last, int[][] points, int[][] dp) {

        //base case
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = points[day][i] + ninjaTrainingHelper(day - 1, i, points, dp);
                max = Math.max(max, activity);
            }
        }
        return dp[day][last] = max;
    }*/

    //tabulation
    /*private static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int activity = points[day][i] + dp[day - 1][i];
                        ;
                        max = Math.max(max, activity);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[n - 1][3];
    }*/

    //space optimize
    private static int ninjaTraining(int n, int[][] points) {
        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] cur = new int[4];
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int activity = points[day][i] + prev[i];
                        max = Math.max(max, activity);
                    }
                }
                cur[last] = max;
            }
            prev = cur;
        }
        return prev[3];
    }
}

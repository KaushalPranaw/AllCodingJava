package Comp.GSGR_PMW3;

import java.util.Arrays;

public class Problem29_MinPlatformTrain {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dept = {910, 1200, 1120, 1130, 1900, 2000};

        int result = findPlatform(arr, dept);
        System.out.println("Minimum platforms required: " + result);
    }

    /*public static int findPlatform(int[] arr, int[] dept) {
        // Sort both arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dept);

        int n = arr.length;
        int platformsNeeded = 0; // Current platforms in use
        int maxPlatforms = 0;    // Maximum platforms required

        int i=0,j=0;
        while (i<n && j<n){
            // New train arrives
            if(arr[i]<=dept[j]){
                platformsNeeded++;
                maxPlatforms=Math.max(maxPlatforms, platformsNeeded);
                i++;
            }
            // Train departs
            else {
                platformsNeeded--;
                j++;
            }
        }
        return maxPlatforms;
    }*/

    public static int findPlatform(int[] arr, int[] dept) {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int n = arr.length;
        int platformNeeded = 0, maxPlatform = 0;

        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dept[j]) {
                platformNeeded++;
                maxPlatform = Math.max(maxPlatform, platformNeeded);
                i++;
            } else {
                platformNeeded--;
                j++;
            }
        }
        return maxPlatform;
    }

}

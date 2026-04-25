package Leetcode.DP.DP02_Subsequence;

import CoreJava.OOPS.pillars.inheritance.B;

import java.util.Arrays;

public class DP16_PartitionTwoSubsetsWithMinAbsoluteSumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
    }

    //recur+memo
    /*public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = Arrays.stream(arr).sum();
        Boolean[][] dp = new Boolean[n][totalSum + 1];
        //not needed as default value of boolean is false
        *//*for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }*//*

        //for all possible target sum(s1), calculate min abs difference with s2(totalSum-s1)
        for (int target = 0; target <= totalSum; target++) {
            minSubsetSumDifferenceHelper(n - 1, target, arr, dp);
        }

        int min = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum/2; s1++) {
            //if (dp[n - 1][s1] != null && dp[n - 1][s1] == true)
            if (Boolean.TRUE.equals(dp[n - 1][s1]))//doing null check+boolean check in one
            {
                int s2 = totalSum - s1;
                int diff = Math.abs(s1 - s2);
                min = Math.min(min, diff);
            }
        }
        return min;
    }

    private static boolean minSubsetSumDifferenceHelper(int ind, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) {
            return dp[ind][target] = true;
        }

        if (ind == 0) {
            return dp[ind][target] = (arr[ind] == target);
        }

        if (dp[ind][target] != null) return dp[ind][target];

        boolean notTaken = minSubsetSumDifferenceHelper(ind - 1, target, arr, dp);
        boolean taken = false;
        if (target - arr[ind] >= 0) {
            taken = minSubsetSumDifferenceHelper(ind - 1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = notTaken || taken;
    }*/

    //tabulation
    /*private static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum=Arrays.stream(arr).sum();
        boolean[][] dp=new boolean[n][totalSum+1];
        //base case
        *//*if (target == 0) {
            return dp[ind][target] = true;
        }*//*
        //means for all i and target 0, dp[i][0] is true
        for(int ind=0;ind<n;ind++){
            dp[ind][0]=true;
        }
        *//*if (ind == 0) {
            return dp[ind][target] = (arr[ind] == target);
        }*//*
        //means for target=arr[0], dp[0][arr[0]]=true
        if(totalSum-arr[0]>=0){
            dp[0][arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=totalSum;target++){
                //copy paste from subset sum equal to target
                *//*boolean notTaken = minSubsetSumDifferenceHelper(ind - 1, target, arr, dp);
                boolean taken = false;
                if (target - arr[ind] >= 0) {
                    taken = minSubsetSumDifferenceHelper(ind - 1, target - arr[ind], arr, dp);
                }

                return dp[ind][target] = notTaken || taken;*//*
                boolean notTaken=dp[ind-1][target];
                boolean taken=false;
                if(target-arr[ind]>=0){
                    taken=dp[ind-1][target-arr[ind]];
                }
                dp[ind][target]=notTaken||taken;
            }
        }

        int min=Integer.MAX_VALUE;
        for(int s1=0;s1<=totalSum/2;s1++){
            if(dp[n - 1][s1]){
                int s2=totalSum-s1;
                int diff=Math.abs(s1-s2);
                min=Math.min(min, diff);
            }
        }
        return min;
    }*/

    //space
    private static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum=Arrays.stream(arr).sum();
        boolean[] prev=new boolean[totalSum+1];
        //base case
        //means for all i and target 0, dp[i][0] is true
        //loop not required as default value of boolean is false and we will set prev[0]=true before loop
        //for(int ind=0;ind<n;ind++){
        prev[0]=true;
        //}
        //means for target=arr[0], dp[0][arr[0]]=true
        if(totalSum-arr[0]>=0){
            prev[arr[0]]=true;
        }

        for(int ind=1;ind<n;ind++){
            boolean[] cur=new boolean[totalSum+1];
            cur[0]=true;//sum = 0 is always possible” ❌ gets lost after first iteration
            for(int target=1;target<=totalSum;target++){
                //copy paste from subset sum equal to target

                boolean notTaken=prev[target];
                boolean taken=false;
                if(target-arr[ind]>=0){
                    taken=prev[target-arr[ind]];
                }
                cur[target]=notTaken||taken;
            }
            prev=cur;
        }

        int min=Integer.MAX_VALUE;
        for(int s1=0;s1<=totalSum/2;s1++){
            if(prev[s1]){
                int s2=totalSum-s1;
                int diff=Math.abs(s1-s2);
                min=Math.min(min, diff);
            }
        }
        return min;
    }
}

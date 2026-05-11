package May2026.DSA.Day3.DSA.PrefixSum;

import java.util.Arrays;
import java.util.HashMap;

public class PS02_EquibriumIndex {
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int n = arr.length;

        int equilibriumIndex = findEquilibriumIndex(arr, n);
        System.out.println("The equilibrium index is: " + equilibriumIndex);
    }

    /*private static int findEquilibriumIndex(int[] arr, int n) {
        //formula : totalSum = leftSum + arr[i] + rightSum
        //for equilibrium index leftSum = rightSum
        //so, leftsum=prefix[i-1]
        //rightSum=totalSum-prefix[i]
        //example
        //arr[] = {-7, 1, 5, 2, -4, 3, 0}
        //totalSum = 0
        //for index 3, leftSum = prefix[2] = means [-7,1,5]=-1
        //rightSum = total-leftsum-arr[i]=total-prefix[i]=0-(-1)-2=-1
        //so, equilibrium index is 3 since equal left and right sum

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int totalSum = prefixSum[n - 1];

        for (int i = 0; i < n; i++) {
            int leftSum = i > 0 ? prefixSum[i - 1] : 0;
            int rightSum = totalSum - prefixSum[i];//=>totalSum - (leftSum + arr[i])

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;

    }*/

    private static int findEquilibriumIndex(int[] arr, int n) {
        int totalSum = 0;

        for(int num : arr){
            totalSum += num;
        }

        int leftSum = 0;

        for(int i=0;i<arr.length;i++){

            int rightSum =
                    totalSum
                            - leftSum
                            - arr[i];

            if(leftSum == rightSum){
                return i;
            }

            //phle check kr rhe hai taki current wala na add ho left sum me
            leftSum += arr[i];
        }

        return -1;
    }

}

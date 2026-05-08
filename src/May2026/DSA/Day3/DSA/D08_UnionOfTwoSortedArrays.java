package May2026.DSA.Day3.DSA;

import java.util.ArrayList;
import java.util.List;

public class D08_UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        //Input:n = 10,m = 7,arr1[] = {1,2,3,4,5,6,7,8,9,10}arr2[] = {2,3,4,4,5,11,12}
        //Output: {1,2,3,4,5,6,7,8,9,10,11,12}
        //Explanation: Common Elements in arr1 and arr2  are:  2,3,4,5
        //Distnict Elements in arr1 are : 1,6,7,8,9,10
        //Distnict Elemennts in arr2 are : 11,12
        //Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12}

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

        List<Integer> result = findUnion(arr1, arr2);

        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : result) System.out.print(val + " ");
    }

    private static List<Integer> findUnion(int[] arr1, int[] arr2) {
        int i=0, j=0;
        List<Integer> unionList=new ArrayList<>();
        while (i<arr1.length && j< arr2.length){
            if(arr1[i]<=arr2[j]){
                if(unionList.isEmpty() || unionList.getLast()!=arr1[i]){
                    unionList.add(arr1[i]);
                }
                i++;
            }else {
                if(unionList.isEmpty()|| unionList.getLast()!=arr2[j]){
                    unionList.add(arr2[j]);
                }
                j++;
            }
        }

        while (i<arr1.length){
            if(unionList.getLast()!=arr1[i]){
                unionList.add(arr1[i]);
            }
            i++;
        }

        while (j<arr2.length){
            if(unionList.getLast()!=arr2[j]){
                unionList.add(arr2[j]);
            }
            j++;
        }

        return unionList;
    }
}

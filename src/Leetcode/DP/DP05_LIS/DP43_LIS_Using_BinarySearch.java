package Leetcode.DP.DP05_LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DP43_LIS_Using_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " +
                lisUsingBinarySearch(arr, n));
    }

    private static int lisUsingBinarySearch(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
                len++;
            } else {
                int index = Collections.binarySearch(temp, arr[i]);
                if (index < 0) {
                    //support it is -1
                    //-index-1= -(-1) - 1 = 1 - 1 = 0
                    index = -index - 1;  // Convert negative return value to insertion point
                }
                temp.set(index, arr[i]);
            }
        }
        return len;

    }
}

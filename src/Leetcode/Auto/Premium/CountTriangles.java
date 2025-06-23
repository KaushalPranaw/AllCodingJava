package Leetcode.Auto.Premium;

import java.util.Arrays;

public class CountTriangles {
    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 7};
        System.out.println(countTriangles(arr));
    }

    private static int countTriangles(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = 2; i < arr.length; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

}

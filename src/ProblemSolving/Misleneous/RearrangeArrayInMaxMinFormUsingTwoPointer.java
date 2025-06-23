package ProblemSolving.Misleneous;

import java.util.Arrays;

public class RearrangeArrayInMaxMinFormUsingTwoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;

        int[] res = new int[n];
        boolean flag = true;
        int right = n - 1, left = 0;

        for (int i = 0; i < n; i++) {
            if (flag) {
                res[i] = arr[right--];
            } else {
                res[i] = arr[left++];
            }
            flag = !flag;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }
}

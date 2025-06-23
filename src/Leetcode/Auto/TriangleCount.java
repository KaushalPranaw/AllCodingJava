package Leetcode.Auto;

import java.util.ArrayList;
import java.util.List;

public class TriangleCount {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 4};
        System.out.println(solution(arr1)); // Output: [1, 0]

        int[] arr2 = {2, 10, 2, 10, 2};
        System.out.println(solution(arr2)); // Output: [0, 1, 0]

        int[] arr3 = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(solution(arr3)); // Output: [1, 1]
    }

    private static List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = i + 2;
            if ((arr[i] + arr[j] > arr[k]) && (arr[j] + arr[k] > arr[i]) && (arr[k] + arr[i] > arr[j])) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }
        return answer;
    }
}

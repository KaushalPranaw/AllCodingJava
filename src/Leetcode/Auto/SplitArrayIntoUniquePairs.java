package Leetcode.Auto;

import java.util.*;

public class SplitArrayIntoUniquePairs {
    public static void main(String[] args) {
        int[] a1 = {2, 1, 2, 3, 3, 4};
        System.out.println(solution(a1)); // Output: [[2, 1, 3], [2, 3, 4]]

        int[] a2 = {1, 2, 2, 1};
        System.out.println(solution(a2)); // Output: [[1, 2], [2, 1]]

        int[] a3 = {2, 2, 3, 3, 2, 2};
        System.out.println(solution(a3)); // Output: []
    }

    private static List<List<Integer>> solution(int[] arr) {
        if (arr.length % 2 != 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) > 2) {
                return new ArrayList<>();
            }
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> singleOccurrence = new ArrayList<>();
        for (int num : map.keySet()) {
            if (map.get(num) == 2) {
                first.add(num);
                second.add(num);
            } else {
                singleOccurrence.add(num);
            }
        }

        for (int i = 0; i < singleOccurrence.size(); i++) {
            if (singleOccurrence.get(i) % 2 == 0) {
                first.add(singleOccurrence.get(i));
            } else {
                second.add(singleOccurrence.get(i));
            }
        }
        return Arrays.asList(first, second);
    }
}

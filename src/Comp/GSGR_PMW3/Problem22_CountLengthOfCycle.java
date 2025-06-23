package Comp.GSGR_PMW3;

import java.util.HashMap;
import java.util.Map;

public class Problem22_CountLengthOfCycle {
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 0};
        int startIndex1 = 0;
        System.out.println(countLengthOfCycle(arr1, startIndex1)); // Output: 2

        // Test Case 2
        int[] arr2 = {1, 2, 0};
        int startIndex2 = 0;
        System.out.println(countLengthOfCycle(arr2, startIndex2)); // Output: 3

        // Test Case 3 (No cycle)
        int[] arr3 = {1, 2, 3, -1};
        int startIndex3 = 0;
        System.out.println(countLengthOfCycle(arr3, startIndex3)); // Output: -1

        // Test Case 4
        int[] arr4 = {2, 0, 1};
        int startIndex4 = 0;
        System.out.println(countLengthOfCycle(arr4, startIndex4)); // Output: 3

        // Test Case 5 (Single-element cycle)
        int[] arr5 = {0};
        int startIndex5 = 0;
        System.out.println(countLengthOfCycle(arr5, startIndex5)); // Output: 1
    }

    /*public static int countLengthOfCycle(int[] arr, int startIndex) {
        Map<Integer, Integer> visited = new HashMap<>();
        int index = startIndex;
        int step = 0;

        while (index >= 0 && index < arr.length) {
            if (visited.containsKey(index)) {
                return step - visited.get(index); // Cycle length
            }
            visited.put(index, step);
            index = arr[index];
            step++;
        }

        return -1; // No cycle
    }*/

    public static int countLengthOfCycle(int[] arr, int startIndex) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = startIndex;
        int steps = 0;

        while (index >= 0 && index < arr.length) {
            if (map.containsKey(index)) {
                return steps - map.get(index);
            }
            map.put(index, steps);
            index = arr[index];
            steps++;
        }
        return -1;


    }
}

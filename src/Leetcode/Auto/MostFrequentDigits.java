package Leetcode.Auto;

import java.util.*;

public class MostFrequentDigits {
    public static void main(String[] args) {
        int[] a = {25, 2, 3, 57, 38, 41};
        System.out.println(mostFrequentDigits(a)); // Output: [2, 3, 5]
    }

    /*private static List<Integer> mostFrequentDigits(int[] a) {
        int[] digitCount = new int[10];//0-9

        for (int num : a) {
            while (num > 0) {
                int digit = num % 10;
                digitCount[digit]++;
                num /= 10;
            }
        }

        int max = Arrays.stream(digitCount).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (digitCount[i] == max)
                list.add(i);
        }
        Collections.sort(list);
        return list;
    }*/

    private static List<Integer> mostFrequentDigits(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            while (num > 0) {
                int digit = num % 10;
                map.put(digit, map.getOrDefault(digit, 0) + 1);
                num /= 10;
            }
        }

        int max = Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for (int digit : map.keySet()) {
            if (map.get(digit) == max)
                list.add(digit);
        }
        Collections.sort(list);
        return list;
    }
}

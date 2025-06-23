package Comp.AE;

import java.util.*;

public class AE01_AllRepeatedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDuplicates(nums);

        System.out.println("Repeated numbers: " + result);
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;*/

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                list.add(num);
            }
        }
        return list;
    }
}

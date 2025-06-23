package Comp.ReaIndia;

import java.util.HashMap;
import java.util.Map;

public class SecondCandy {
    public static void main(String[] args) {
        int[] candyType = {6,6,6,6};

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : candyType) {
            map.put(num, map.getOrDefault(num, 0) + 1);//3
        }

        System.out.println(Math.min(candyType.length / 2, map.keySet().size()));
    }
}

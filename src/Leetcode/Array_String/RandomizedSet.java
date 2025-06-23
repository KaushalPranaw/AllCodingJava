package Leetcode.Array_String;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;


    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        //if index is not in list, then swap with last and then delete
        if (index != list.size() - 1) {
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            map.put(lastElement, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // Returns either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // Returns 2.
    }
}

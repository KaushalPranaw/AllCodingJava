package Leetcode.Leetcode150.Array_String;

import java.util.*;

public class RandomizedSet {

    private List<Integer> list;//to store element
    private Random random;//for random access
    private Map<Integer, Integer> map;//<element, index> will get index instantly


    public RandomizedSet() {
        list = new ArrayList<>();
        random = new Random();
        map = new HashMap<>();
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

        int pos = map.get(val);
        if (pos != (list.size() - 1)) {
            int lastElement = list.getLast();
            map.put(lastElement, pos);
            list.set(pos, lastElement);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int ran = random.nextInt(list.size());
        return list.get(ran);
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

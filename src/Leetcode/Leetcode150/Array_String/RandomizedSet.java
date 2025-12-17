package Leetcode.Leetcode150.Array_String;

import java.util.*;

public class RandomizedSet {

    private Random random;
    private List<Integer> list;
    private Map<Integer, Integer> map;


    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int pos=map.get(val);
        int lastElement=list.get(list.size()-1);
        if(pos!=list.size()-1){
            list.set(pos, lastElement);
            map.put(lastElement, pos);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        int randomIndex=random.nextInt(list.size());
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

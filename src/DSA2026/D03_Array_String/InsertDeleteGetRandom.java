package DSA2026.D03_Array_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    Random random=new Random();

    public InsertDeleteGetRandom() {
        list=new ArrayList<>();
        map=new HashMap<>();
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
        if(pos!=list.size()-1){
            int lastElement=list.getLast();
            list.set(pos, lastElement);
            map.put(lastElement, pos);
        }
        list.removeLast();
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomInt=random.nextInt(list.size());
        return list.get(randomInt);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();

        System.out.println(obj.insert(1)); // true
        System.out.println(obj.insert(2)); // true
        System.out.println(obj.insert(3)); // true
        System.out.println(obj.insert(2)); // false (duplicate)

        System.out.println(obj.getRandom()); // random: 1/2/3

        System.out.println(obj.remove(2)); // true
        System.out.println(obj.remove(4)); // false

        System.out.println(obj.getRandom()); // random: 1/3

        System.out.println(obj.insert(4)); // true
        System.out.println(obj.getRandom()); // random: 1/3/4
    }
}

package Comp.GSGR_PMW3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem11_FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(findFirst("apple")); // Output: a
        System.out.println(findFirst("racecars")); // Output: e
        System.out.println(findFirst("xxyyzz")); // Output: 0
        System.out.println(findFirst("")); // Output: 0
        System.out.println(findFirst("abcde")); // Output: a
    }

    /*public static char findFirst(String input) {
        Map<Character, Integer> map=new LinkedHashMap<>();

        for(int i=0;i<input.length();i++){
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return '0';
    }*/
    public static char findFirst(String input) {
        /*return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse('0');*/
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry-> entry.getKey())
                .findFirst()
                .orElse('0');
    }
}

package Leetcode.Auto.Premium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        /*Map<String, List<String>> map=new HashMap<>();
        for(String str: strs){
            char[] ca=str.toCharArray();
            Arrays.sort(ca);
            String sorted=new String(ca);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());*/

        Map<String, List<String>> map = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        word -> {
                            char[] ca = word.toCharArray();
                            Arrays.sort(ca);
                            return new String(ca);
                        }
                ));
        return new ArrayList<>(map.values());

    }
}

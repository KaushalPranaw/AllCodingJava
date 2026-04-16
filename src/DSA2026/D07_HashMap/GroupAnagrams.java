package DSA2026.D07_HashMap;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        //Input: strs = ["eat","tea","tan","ate","nat","bat"]
        //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] count=new int[26];
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }
            // build key
            StringBuilder sb=new StringBuilder();
            for(int num: count){
                sb.append(num).append('#');
            }

            String finalKey=sb.toString();
            map.putIfAbsent(finalKey, new ArrayList<>());
            map.get(finalKey).add(s);
        }
        return new ArrayList<>(map.values());

    }

    /*public static List<List<String>> groupAnagrams(String[] strs) {
        *//*Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String sorted = new String(ca);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());*//*
        Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            return new String(ca);
        }));
        return new ArrayList<>(map.values());

    }*/


}

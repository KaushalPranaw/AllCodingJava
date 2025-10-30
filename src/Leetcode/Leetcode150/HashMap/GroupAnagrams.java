package Leetcode.Leetcode150.HashMap;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] ca = s.toCharArray();
                    Arrays.sort(ca);
                    return new String(ca);
                })).values());
    }
}

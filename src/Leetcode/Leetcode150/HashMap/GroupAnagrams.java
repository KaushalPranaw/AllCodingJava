package Leetcode.Leetcode150.HashMap;

import CoreJava.OOPS.pillars.inheritance.A;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        word -> {
                            char[] ch = word.toCharArray();
                            Arrays.sort(ch);
                            return new String(ch);
                        }
                )).values());
    }
}

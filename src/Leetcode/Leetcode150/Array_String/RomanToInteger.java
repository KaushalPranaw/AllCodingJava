package Leetcode.Leetcode150.Array_String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new RomanToInteger().romanToInt(s));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int cur;
        int res = 0;
        int prev = 0;
        for (char ch : s.toCharArray()) {
            cur = map.get(ch);
            if (cur > prev) {
                //since already we have added prev but it should be substracted so prev * 2 we have to remove from cur
                res += cur - (2 *prev);
            } else {
                res += cur;
            }
            prev = cur;
        }
        return res;
    }
}

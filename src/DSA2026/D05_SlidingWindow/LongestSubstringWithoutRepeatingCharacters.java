package DSA2026.D05_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //Input: s = "abcabcbb"
        //Output: 3
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int left=0;
        int maxLen=0;
        Map<Character, Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            //duplicate found, move left to after where duplicate exist in map
            if(map.containsKey(c)){
                left=Math.max(left, map.get(c)+1);
            }

            map.put(c, right);//insert or override in case of same char
            maxLen=Math.max(maxLen, right-left+1);
        }


        return maxLen;
    }
}

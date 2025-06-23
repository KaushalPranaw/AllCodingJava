package Comp.CodeWithComplexity75.DP;

import Comp.google.WordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C20_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode", wordDict[] = {"leet", "code"};
        System.out.println(new WordBreak().wordBreak(s, Arrays.stream(wordDict).toList()));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];

    }
}

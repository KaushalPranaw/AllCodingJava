package Leetcode.Quest.Stack;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperations {
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(new BuildArrayWithStackOperations().buildArray(target, n));

    }

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        //stream of number from 1 to n
        for (int num = 1; num <= n && index < target.length; num++) {
            ans.add("Push");
            if (num == target[index]) {
                index++;
            } else {
                ans.add("Pop");
            }
        }
        return ans;
    }
}

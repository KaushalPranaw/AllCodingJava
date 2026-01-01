package Leetcode.Leetcode150.Backtracking;

import CoreJava.OOPS.pillars.inheritance.A;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSumII().combinationSum2(candidates, target));

    }

    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> wrap = new ArrayList<>();
        getAllCombinations(candidates, target, 0, new ArrayList<>(), wrap);
        return wrap;
    }

    private void getAllCombinations(int[] candidates, int target, int idx, ArrayList<Integer> combination, List<List<Integer>> wrap) {

        //base case
        if (target < 0) {
            return;
        }

        if (target == 0) {
            if (!set.contains(combination)) {
                wrap.add(new ArrayList<>(combination));
                set.add(new ArrayList<>(combination));
                return;
            }
        }

        for (int i = idx; i < candidates.length; i++) {
            //single inclusion
            combination.add(candidates[i]);
            getAllCombinations(candidates, target - candidates[i], i + 1, combination, wrap);
            //exclusion
            combination.remove(combination.size() - 1);
            getAllCombinations(candidates, target, i + 1, combination, wrap);
        }


    }
}

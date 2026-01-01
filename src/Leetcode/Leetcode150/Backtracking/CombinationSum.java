package Leetcode.Leetcode150.Backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> wrap = new HashSet<>();
        getAllCombinations(candidates, target, 0, new ArrayList<>(), wrap);
        return new ArrayList<>(wrap);
    }

    private void getAllCombinations(int[] candidates, int target, int idx, ArrayList<Integer> combination, Set<List<Integer>> set) {

        //base case
        if (idx == candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            set.add(new ArrayList<>(combination));
            return;
        }

        //single inclusion
        combination.add(candidates[idx]);
        getAllCombinations(candidates, target - candidates[idx], idx + 1, combination, set);
        //multi inclusion
        getAllCombinations(candidates, target - candidates[idx], idx, combination, set);
        //exclusion
        combination.remove(combination.size() - 1);
        getAllCombinations(candidates, target, idx + 1, combination, set);
    }

}

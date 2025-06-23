package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    //You are given an array of distinct positive integers (candidates[]).
    //You are also given a target integer.
    //You need to find all unique combinations of numbers from candidates[] that add up exactly to target.
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));

    }

    //for unique combination
    Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //we have 3 choices -[2, 3,5]
        /*
        1. Single inclusion [2]
        2. Multi Inclusion [2,2]
        3. Exclusion [ ]
         */

        List<List<Integer>> answer = new ArrayList<>();
        getAllCombinations(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void getAllCombinations(int[] candidates, int target, int i, List<Integer> combination, List<List<Integer>> answer) {
        //base case
        if (target == 0) {
            if(!set.contains(combination))
            {
                answer.add(new ArrayList<>(combination)); // Found a valid combination
                set.add(new ArrayList<>(combination));
                return;
            }

        }

        if (target < 0 || i == candidates.length) {
            return; // Stop if sum exceeds target
        }

        //step1:single inclusion case
        combination.add(candidates[i]);
        getAllCombinations(candidates, target - candidates[i], i + 1, combination, answer);

        //step:2 multi inclusion
        //since already added into combination so right now not needed to add
        //just instead i+1 , we have to do i
        getAllCombinations(candidates, target - candidates[i], i, combination, answer);

        //Step:3 exclusion
        //since we have added into combination, so we have to remove
        //means backtrack
        combination.remove(combination.size() - 1);
        getAllCombinations(candidates, target, i + 1, combination, answer);
    }

}

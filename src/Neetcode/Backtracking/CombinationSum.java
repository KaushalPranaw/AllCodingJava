package Neetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //we have 3 choices -[2, 3,5]
        /*
        1. Single inclusion [2]
        2. Multi Inclusion [2,2]
        3. Exclusion [ ]
         */
        List<List<Integer>> wrap = new ArrayList<>();
        combinations(0, new ArrayList<>(), candidates, target, wrap);
        return wrap;
    }

    private void combinations(int idx, List<Integer> list, int[] candidates, int target, List<List<Integer>> wrap) {
        if (target == 0) {
            wrap.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || idx == candidates.length) {
            return; // Stop if sum exceeds target
        }
        // ✅ include current element (stay at same idx since reuse allowed)
        list.add(candidates[idx]);
        combinations(idx, list, candidates, target - candidates[idx], wrap);
        list.remove(list.size() - 1); // backtrack

        // ✅ exclude current element (move to next index)
        combinations(idx + 1, list, candidates, target, wrap);
    }
}

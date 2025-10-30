package Leetcode.Leetcode150.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> wrap = new ArrayList<>();
        getPermutations(nums, 0, wrap);
        return wrap;
    }

    private void getPermutations(int[] nums, int idx, List<List<Integer>> ans) {
        int n = nums.length;
        if (idx == n) {
            ans.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(nums, idx, i);
            getPermutations(nums, idx + 1, ans);
            swap(nums, idx, i);//backtrack
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

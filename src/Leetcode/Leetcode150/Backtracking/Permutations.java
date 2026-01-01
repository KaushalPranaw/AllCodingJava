package Leetcode.Leetcode150.Backtracking;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }

    //using simple way
    //using normal traditional way
    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> wrap = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        solve(nums, wrap, new ArrayList<>(), set);
        return wrap;
    }

    private void solve(int[] nums, List<List<Integer>> wrap, ArrayList<Integer> list, Set<Integer> set) {
        if (list.size() == nums.length) {
            wrap.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                list.add(nums[i]);
                set.add(nums[i]);
                solve(nums, wrap, list, set);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }*/

    //using idx way
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> wrap = new ArrayList<>();
        solve(0, nums, wrap);
        return wrap;
    }

    private void solve(int idx, int[] nums, List<List<Integer>> wrap) {
        if (idx == nums.length) {
            wrap.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            solve(idx + 1, nums, wrap);
            swap(i, idx, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}

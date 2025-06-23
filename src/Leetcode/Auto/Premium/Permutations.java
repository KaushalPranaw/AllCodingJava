package Leetcode.Auto.Premium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permutations().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPermutations(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void getPermutations(int[] nums, int idx, List<List<Integer>> ans, List<Integer> permutation) {
        // base case
        if (idx == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = idx; i < nums.length; i++) { // Start loop from idx, not 0
            swap(idx, i, nums); // Swap at idx and i
            permutation.add(nums[idx]);
            getPermutations(nums, idx + 1, ans, permutation);
            permutation.remove(permutation.size() - 1);
            swap(idx, i, nums); // Backtrack
        }
    }

    void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPermutations(nums, 0, ans);
        return ans;
    }

    private void getPermutations(int[] nums, int idx, List<List<Integer>> ans) {
        // base case
        if (idx == nums.length) {
            // Create a new List<Integer> from the current nums array
            List<Integer> permutation = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList());
            ans.add(permutation);
            return;
        }

        for (int i = idx; i < nums.length; i++) { // Start loop from idx, not 0
            swap(idx, i, nums); // Swap at idx and i
            getPermutations(nums, idx + 1, ans);
            swap(idx, i, nums); // Backtrack
        }
    }*/
}

package Neetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> wrap = new ArrayList<>();
        combinations(0, new ArrayList<>(), wrap, nums);
        return wrap;
    }

    private void combinations(int idx, List<Integer> list, List<List<Integer>> wrap, int[] nums) {
        wrap.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            // Include nums[i]
            list.add(nums[i]);
            combinations(i + 1, list, wrap, nums);
            // Backtrack (remove last added element)
            list.remove(list.size() - 1);
        }
    }
}

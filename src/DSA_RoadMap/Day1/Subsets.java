package DSA_RoadMap.Day1;

import CoreJava.OOPS.pillars.inheritance.A;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

    /*
    [
         [],
         [1], [1,2], [1,2,3], [1,3],
         [2], [2,3],
         [3]
    ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> wrap = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), wrap);
        return wrap;
    }

    private void helper(int[] nums, int idx, ArrayList<Integer> list, List<List<Integer>> wrap) {
        //since we have to found all subsets
        wrap.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, list, wrap);
            list.remove(list.size() - 1);
        }
    }


}

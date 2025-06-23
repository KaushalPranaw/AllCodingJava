package Comp.CodeWithComplexity75.Array;

import java.util.HashSet;
import java.util.Set;

public class C03_ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new C03_ContainsDuplicate().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;

    }
}

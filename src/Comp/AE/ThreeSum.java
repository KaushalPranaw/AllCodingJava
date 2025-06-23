package Comp.AE;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, -2};

        List<List<Integer>> result = threeSum(nums);
        System.out.println("Triplets that sum to zero: ");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        //a+b+c=0
        //a+b=-c
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    set.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(set);

    }
}

package Comp.AE;

import java.util.*;

public class ThreeSumEqualsToK {
    public static void main(String[] args) {
        int[] nums = {1, 2, -1, -1, -2, 3};
        int k = 2;

        List<List<Integer>> result = threeSum(nums, k);
        System.out.println("Triplets that sum to k: ");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    /*public static List<List<Integer>> threeSum(int[] nums, int k) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3) {
            return new ArrayList<>(set);
        }

        //a+b+c=k
        //a+b=c-k;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate elements for 'i' to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = k-nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    set.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicate elements for 'left' and 'right' to avoid duplicate triplets
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(set);

    }*/

    public static List<List<Integer>> threeSum(int[] nums, int k) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = k - nums[i];
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int rem = target - nums[j];
                if (seen.contains(rem)) {
                    set.add(List.of(nums[i], rem, nums[j]));
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }
}

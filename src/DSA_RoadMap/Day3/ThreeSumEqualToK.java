package DSA_RoadMap.Day3;

import java.util.*;

public class ThreeSumEqualToK {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        int k = 3;
        System.out.println(new ThreeSumEqualToK().threeSum(nums, k));
    }

    public List<List<Integer>> threeSum(int[] nums, int k) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = k - nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
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

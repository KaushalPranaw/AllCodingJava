package DSA2026.D04_TwoPointers;

import java.util.*;

public class ThreeSumEqualsK {
    public static void main(String[] args) {
        //Input: nums = [-1,0,1,2,-1,-4]
        //Output: [[0, 1, 2]]
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int k=3;
        System.out.println(threeSum(nums, k));
    }

    public static List<List<Integer>> threeSum(int[] nums, int k) {
        //a+b+c=k;
        //a+b=k-c;
        Arrays.sort(nums);
        Set<List<Integer>> lists = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = k-nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    lists.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(lists);

    }
}

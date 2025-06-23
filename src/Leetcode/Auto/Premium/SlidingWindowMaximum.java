package Leetcode.Auto.Premium;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Monotonic deque storing indices

        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
                //last element remove kr do if window size reach
            }

            //Remove Smaller Elements from the Back of Deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add the current index to the deque
            deque.offer(i);

            // Add the max value (front of deque) to the result when window size reaches k
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }

        }
        return result;

    }
}

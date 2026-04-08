package DSA2026.D02_Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));

    }

    public static int findKthLargest(int[] nums, int k) {

        //create minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //populate k element
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        //populate n-k element
        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();

    }
}

package Leetcode.Leetcode150.Heap;
/*You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.



Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]*/

import java.util.*;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int nums1[] = {1, 7, 11}, nums2[] = {2, 4, 6}, k = 3;
        System.out.println(new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k));

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return list;
        }

        //we have to create PriorityQueue
        //we will compare by sum of pair
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int sum1 = (nums1[a[0]] + nums2[a[1]]);
            int sum2 = (nums1[b[0]] + nums2[b[1]]);
            return Integer.compare(sum1, sum2);
        });

        //now put one array element into heap
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            //comparing num1 element with num2's first element
            minHeap.add(new int[]{i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] arr = minHeap.poll();
            int i = arr[0];
            int j = arr[1];
            k--;
            list.add(Arrays.asList(nums1[i], nums2[j]));
            //since we have polled
            //we can add one element from num2
            if (j + 1 < nums2.length) {
                minHeap.add(new int[]{i, j + 1});
            }
        }
        return list;

    }

}
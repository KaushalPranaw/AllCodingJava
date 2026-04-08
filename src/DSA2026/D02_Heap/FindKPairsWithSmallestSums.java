package DSA2026.D02_Heap;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //create minHeap for pairs of index
        /*PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) ->
                        Integer.compare((nums1[a[0]] + nums2[a[1]]), (nums1[b[0]] + nums2[b[1]])));
        */
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));

        //create ans
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }

        //store min(k, nums1.len) elements in heap
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.add(new int[]{i, 0});
        }

        //using loop pop and add next for same ith element
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[0];
            int j = pair[1];

            ans.add(List.of(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.add(new int[]{i, j + 1});
            }
        }
        return ans;
    }
}

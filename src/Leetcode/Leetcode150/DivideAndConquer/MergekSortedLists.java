package Leetcode.Leetcode150.DivideAndConquer;

import java.util.PriorityQueue;

public class MergekSortedLists {
    public static void main(String[] args) {
        MergekSortedLists solution = new MergekSortedLists();
        // Example 1
        ListNode[] lists1 = new ListNode[3];
        lists1[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists1[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists1[2] = new ListNode(2, new ListNode(6));

        ListNode result1 = solution.mergeKLists(lists1);
        result1.print(result1);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;

    }
}

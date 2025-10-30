package Leetcode.Leetcode150.LinkedList;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode node = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
        node.print(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        /*Use a dummy node before the head (to handle cases where head itself is a duplicate).
        Use a pointer prev to track the last node before a duplicate sequence.
        Traverse with head.
        If head.val == head.next.val, skip all nodes with that value.
        Otherwise, move prev forward.
        Return dummy.next as the new head.*/

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;

    }
}

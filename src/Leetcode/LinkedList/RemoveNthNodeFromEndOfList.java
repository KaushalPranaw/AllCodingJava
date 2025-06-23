package Leetcode.LinkedList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        //head = [1,2,3,4,5], n = 2
        //1,2,3,5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode node = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        node.print(node);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         1,2,3,4,5
             s
                   f
         */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }
}

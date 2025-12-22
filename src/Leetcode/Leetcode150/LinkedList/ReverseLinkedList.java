package Leetcode.Leetcode150.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode node = reverseLL(l1);
        node.print(node);

    }

    private static ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head, prev = null, next = null;
        while (cur != null) {
            //save next
            next = cur.next;

            // reverse pointer
            cur.next = prev;

            // move prev
            prev = cur;

            // move prev
            cur = next;

        }
        return prev;//new head;
    }
}

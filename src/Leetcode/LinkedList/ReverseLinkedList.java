package Leetcode.LinkedList;

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

        ListNode cur = head, prev = null, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

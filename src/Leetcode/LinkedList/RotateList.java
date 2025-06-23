package Leetcode.LinkedList;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode node = new RotateList().rotateRight(head, k);
        node.print(node);

    }

    public ListNode rotateRight(ListNode head, int k) {
        //1,2,3,4,5
        //k=2
        //4,5,1,2,3
        //Edge case
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        //calc len
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;

        //form circle
        tail.next = head;

        //find new tail
        int stepToNewHead = len - k;
        ListNode newTail = head;
        for (int i = 0; i < stepToNewHead - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }
}

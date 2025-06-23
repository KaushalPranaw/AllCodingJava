package Leetcode.LinkedList;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        //head = [1,2,3,4,5], k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        ListNode node = obj.reverseKGroup(head, k);
        node.print(node);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if (count < k) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null, next = null;
        count = 0;
        while (cur != null && count < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}

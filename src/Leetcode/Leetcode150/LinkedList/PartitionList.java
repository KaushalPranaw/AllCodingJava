package Leetcode.Leetcode150.LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        //head = [1,4,3,2,5,2], x = 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        ListNode node = new PartitionList().partition(head, x);
        node.print(node);
    }

    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode sp = small, lp = large;

        while (head != null) {
            if (head.val < x) {
                sp.next = head;
                sp = sp.next;
            } else {
                lp.next = head;
                lp = lp.next;
            }
            head = head.next;
        }
        sp.next = large.next;
        lp.next = null;
        return small.next;
    }
}

package Leetcode.Leetcode150.LinkedList;

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

        // Step 1: Check if we have k nodes to reverse
        int count = 0;
        ListNode temp = head;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        if (count < k) {
            return head;
        }


        // Step 2: Reverse the first k nodes
        count = 0;
        ListNode cur = head, next = null, prev = null;
        while (cur != null && count < k) {
            count++;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }


        // Step 3: Recursively reverse the remaining list and connect i
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}

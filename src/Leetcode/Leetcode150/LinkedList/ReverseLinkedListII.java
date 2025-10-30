package Leetcode.Leetcode150.LinkedList;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int left1 = 2, right1 = 4;
        ListNode reversed1 = new ReverseLinkedListII().reverseBetween(head1, left1, right1);
        reversed1.print(reversed1); // Expected: 1 -> 4 -> 3 -> 2 -> 5

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // Step 1: Add dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move prev to the node before left
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Start reversing
        ListNode curNode = prev.next;
        ListNode nextNode;
        ListNode prevNode = null;

        // Reverse (right - left) times
        for (int i = 0; i <= (right - left); i++) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        prev.next.next = curNode;
        prev.next = prevNode;

        return dummy.next;


    }
}

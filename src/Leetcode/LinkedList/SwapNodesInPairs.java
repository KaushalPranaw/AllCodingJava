package Leetcode.LinkedList;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        // Swap nodes in pairs
        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode newHead = solution.swapPairs(head);

        // Print the swapped list
        newHead.print(newHead); // Expected output: 2 -> 1 -> 4 -> 3
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;//1;
            ListNode second = first.next;//2

            // Perform the swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev to the next pair
            prev = first;
        }
        return dummy.next;
    }
}

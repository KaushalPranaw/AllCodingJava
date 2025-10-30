package Leetcode.Leetcode150.LinkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        // Creating a linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle (fourth node points back to second)

        LinkedListCycle cycleDetector = new LinkedListCycle();
        boolean result = cycleDetector.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + result);

    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }
}

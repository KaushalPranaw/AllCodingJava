package DSA2026.D10_LinkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle obj = new LinkedListCycle();

        // Create nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create cycle: last node points back to second node
        fourth.next = second;

        // Test
        System.out.println(obj.hasCycle(head)); // true

        // Break cycle to test false case
        fourth.next = null;

        System.out.println(obj.hasCycle(head)); // false
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
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

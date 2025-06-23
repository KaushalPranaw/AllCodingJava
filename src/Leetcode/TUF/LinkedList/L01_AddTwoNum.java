package Leetcode.TUF.LinkedList;

public class L01_AddTwoNum {
    public static void main(String[] args) {
        // Sample input to test the function: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = new L01_AddTwoNum().addTwoNumbers(l1, l2);
        printList(result); // Expected output: 7 -> 0 -> 8
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        // If there's any carry left
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;

    }
    // Utility method to print the linked list
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}

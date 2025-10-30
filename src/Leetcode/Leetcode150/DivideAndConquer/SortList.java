package Leetcode.Leetcode150.DivideAndConquer;

public class SortList {
    public static void main(String[] args) {
        SortList solution = new SortList();
        // Test case 1
        int[] arr1 = {4, 2, 1, 3};
        ListNode head1 = ListNode.createList(arr1);
        ListNode sortedHead1 = solution.sortList(head1);
        sortedHead1.print(sortedHead1);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // Step 2: Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge the two sorted halves
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;

    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

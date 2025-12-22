package Leetcode.Leetcode150.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Example usage:
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        ListNode t1 = l1;
        while (t1 != null) {
            System.out.print(t1.val + " ");
            t1 = t1.next;
        }
        System.out.println();
        ListNode t2 = l2;
        while (t2 != null) {
            System.out.print(t2.val + " ");
            t2 = t2.next;
        }
        System.out.println();

        // Print the result:
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(); // Newline


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur=cur.next;
            carry = sum / 10;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            cur=cur.next;
            carry = sum / 10;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            cur.next = new ListNode(sum % 10);
            l2 = l2.next;
            cur=cur.next;
            carry = sum / 10;
        }

        if(carry!=0){
            cur.next=new ListNode(carry);
        }

        return dummy.next;
    }
}

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
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            l2 = l2.next;
        }

        if(carry!=0){
            ans.next=new ListNode(carry);
        }

        return dummy.next;
    }
}

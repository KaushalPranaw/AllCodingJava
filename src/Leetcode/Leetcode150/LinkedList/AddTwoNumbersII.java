package Leetcode.Leetcode150.LinkedList;

import java.util.Stack;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        // l1 = [7,2,4,3]
        ListNode l1 = buildList(new int[]{7,2,4,3});

        // l2 = [5,6,4]
        ListNode l2 = buildList(new int[]{5,6,4});

        AddTwoNumbersII solution = new AddTwoNumbersII();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.print("List1: ");
        printList(l1);

        System.out.print("List2: ");
        printList(l2);

        System.out.print("Result: ");
        printList(result);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Since digits are most-significant-first, we simulate reverse order using two stacks.
        /*
        💡 Idea

            Push all digits of l1 into stack1
            Push all digits of l2 into stack2
            Pop from stacks → add digits + carry
            Insert node at front of result list
         */

        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        while (l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }

        while (l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }

        int carry=0;
        ListNode head=null;// since we need to do InsertAtStart
        while (!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            int sum=carry;
            if(!s1.isEmpty()) sum+=s1.pop();
            if(!s2.isEmpty()) sum+=s2.pop();

            //now insert at front
            ListNode node=new ListNode(sum%10);
            node.next=head;
            head=node;

            //update carry
            carry=sum/10;
        }
        return head;
    }

    static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

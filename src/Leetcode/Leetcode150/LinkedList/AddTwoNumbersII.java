package Leetcode.Leetcode150.LinkedList;

import java.util.Stack;

public class AddTwoNumbersII {
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

    //yhi TODO hai main code
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Since digits are most-significant-first, we simulate reverse order using two stacks.
        /*
        💡 Idea

            Push all digits of l1 into stack1
            Push all digits of l2 into stack2
            Pop from stacks → add digits + carry
            Insert node at front of result list
         */

        //1. create stack
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        //2. push l1 to stack1 and l2 to stack2
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }

        //3. now pop 1 by 1 and code of insert at frnt
        ListNode head=null;
        int carry=0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int sum=carry;
            if(!stack1.isEmpty()){
                sum+=stack1.pop();
            }
            if(!stack2.isEmpty()){
                sum+=stack2.pop();
            }

            //now insert at front code
            ListNode newNode=new ListNode(sum%10);
            newNode.next=head;
            head=newNode;

            //update carry
            carry=sum/10;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;

    }
}

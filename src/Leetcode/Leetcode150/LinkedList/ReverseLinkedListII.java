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
        //base case
        if(left==right|| head==null || head.next==null){
            return head;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode prev=dummy;
        //move prev to the  node before left
        for(int i=1;i<left;i++){
            prev=prev.next;
        }

        //reverse from left to right
        ListNode curNode=prev.next, nextNode=null, prevNode=null;
        for(int i=0;i<=(right-left);i++) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode=curNode;
            curNode=nextNode;
        }

        prev.next.next=curNode;
        prev.next=prevNode;

        return dummy.next;

    }
}

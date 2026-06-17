package Leetcode.Leetcode150.LinkedList;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        //head = [1,2,3,4,5], k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        ListNode node = obj.reverseKGroup(head, k);
        node.print(node);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode temp=head;
        ListNode prevNode=null;
        while (temp!=null){
            ListNode kthNode=getKthNode(temp, k);
            if(kthNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }

            ListNode nextNode=kthNode.next;
            kthNode.next=null;

            ListNode reversedHead = reverseLL(temp);
            if(temp==head){
                head=reversedHead;
            }else {
                prevNode.next=reversedHead;
            }

            prevNode=temp;
            temp=nextNode;
        }
        return head;

    }

    private ListNode reverseLL(ListNode temp) {
        ListNode cur=temp, next=null, prev=null;
        while (cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;

    }

    //get Kth node
    ListNode getKthNode(ListNode temp, int k){
        k--;
        while (temp!=null &&  k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
}

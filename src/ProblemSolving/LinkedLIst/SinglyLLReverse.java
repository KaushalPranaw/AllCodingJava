package ProblemSolving.LinkedLIst;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
}

public class SinglyLLReverse {
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.head = new Node(10);
        obj.head.next = new Node(20);
        obj.head.next.next = new Node(30);
        obj.head.next.next.next = new Node(40);
        obj.head.next.next.next.next = new Node(50);
        print(obj.head);
        //obj.head = reverse(obj.head);
        //obj.head = deleteAtBeginningNode(obj.head);
        //obj.head = deleteAtLastNode(obj.head);
        //print(obj.head);
        /*obj.head = deleteAtSpecificNode(obj.head, 0);
        print(obj.head);*/

        //rotate
        obj.head = rotateLL(obj.head, 14);
        print(obj.head);
    }

    private static Node rotateLL(Node head, int k) {
        //10 -> 20 -> 30 -> 40 ->  50 ->  60 -> 70

        int len = 0;

        Node last = head;
        while (last.next != null) {
            len++;
            last = last.next;
        }
        len++;//5
        k = k % len;
        //14%5=4
        last.next = head;

        Node temp = head;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        Node tempNext = temp.next;
        temp.next = null;
        return tempNext;
    }

    private static Node deleteAtSpecificNode(Node head, int pos) {
        if (head == null || pos < 1) {
            return null;
        }
        if (pos == 1) {
            return deleteAtBeginningNode(head);
        }
        Node dummy = new Node(0);
        dummy.next = head;
        for (int i = 0; i < pos - 2; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;

    }

    private static Node deleteAtLastNode(Node head) {
        if (head == null || head.next == null) {

            return null;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;

    }

    private static Node deleteAtBeginningNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        return head.next;

    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node reverse(Node head) {
        Node cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static Node deleteAtMiddleNode(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}

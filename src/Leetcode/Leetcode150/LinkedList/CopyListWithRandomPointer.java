/*
package Leetcode.Leetcode150.LinkedList;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        // Create nodes
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);

        // Set next pointers
        n1.next = n2;
        n2.next = n3;

        // Set random pointers
        n1.random = null;
        n2.random = n1;   // 13 -> 7
        n3.random = n2;   // 11 -> 13

        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();

        System.out.println("Original List:");
        printList(n1);

        Node copiedHead = obj.copyRandomList(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }
    // Helper print method
    static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            int randomVal = (cur.random == null) ? -1 : cur.random.val;
            System.out.println("Val=" + cur.val +
                    " Next=" + (cur.next != null ? cur.next.val : "null") +
                    " Random=" + (randomVal == -1 ? "null" : randomVal));
            cur = cur.next;
        }
    }

    */
/*
    Each node has:
        value
        next pointer → next node
        random pointer → can point to ANY node (or null)

    You must create a deep copy:

        New nodes only
        Same values
        Same next structure
        Same random structure
        ❌ No pointer in new list should point to old nodes
     *//*

    public Node copyRandomList(Node head) {

        //Best Interview Approach — O(1) Space Trick
        //No HashMap needed. We copy nodes in-place using 3 passes.
        //Step 1 — Insert copied nodes between original nodes
        //Step 2 — Set random pointers for copied nodes
        //Step 3 — Separate the two lists

        if (head == null) {
            return head;
        }

        Node cur = head;
        //Step 1 — Insert copied nodes between original nodes
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        //Step 2 — Set random pointers for copied nodes
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
                //original.random.next = copied random node
            }
            cur = cur.next.next;
        }

        //Step 3 — Separate the two lists
        cur = head;
        Node dummy = new Node(0);
        Node temp = dummy;
        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next;
            temp.next = copy;
            temp = copy;
            cur = cur.next;
        }
        return dummy.next;

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}*/

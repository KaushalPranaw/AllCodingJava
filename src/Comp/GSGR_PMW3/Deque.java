package Comp.GSGR_PMW3;

public class Deque {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add to the front of the deque
    public void addFirst(String item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add to the end of the deque
    public void addLast(String item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Remove from the front of the deque
    public String removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        String item = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return item;
    }

    // Remove from the end of the deque
    public String removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        String item = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return item;
    }

    // Get the first element without removing
    public String peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return head.data;
    }

    // Get the last element without removing
    public String peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return tail.data;
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size of deque
    public int size() {
        return size;
    }

    // Test the implementation
    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("New First");

        System.out.println(deque.removeFirst()); // "New First"
        System.out.println(deque.removeLast());  // "Last"
        System.out.println(deque.peekFirst());   // "First"
        System.out.println(deque.size());        // 1
    }
}

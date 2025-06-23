package Leetcode.Auto.Premium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key, value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head, tail;
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            insertNode(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }

        if (map.size() == capacity) {
            removeNode(tail.prev);
        }

        insertNode(new Node(key, value));

    }

    private void removeNode(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void insertNode(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2); // Capacity of 2

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}

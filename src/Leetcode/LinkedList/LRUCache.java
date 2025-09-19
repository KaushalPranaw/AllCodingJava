package Leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node{
        Node prev, next;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head=new Node(0, 0);
    Node tail=new Node(0, 0);
    int capacity;
    Map<Integer, Node> map=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else {
            return -1;
        }
    }
    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==this.capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    void insert(Node node){
        map.put(node.key, node);
        Node headNext=head.next;
        head.next=node;
        node.prev=head;
        node.next=headNext;
        headNext.prev=node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4

        System.out.println("---Another Test Case---");
        LRUCache lruCache2 = new LRUCache(2);
        lruCache2.put(2, 1);
        lruCache2.put(2, 2);
        System.out.println(lruCache2.get(2));
        lruCache2.put(1, 1);
        lruCache2.put(4, 1);
        System.out.println(lruCache2.get(2));
    }

}

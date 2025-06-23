package Leetcode.Auto.Premium;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class Pair {
        Node node;
        int hd; // Horizontal Distance

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void main(String[] args) {
        // Example tree:
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Top View of the tree:");
        topView(root); // Output: 4 2 1 3 7
    }
    public static void topView(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, Integer> topViewMap=new TreeMap<>();
        Queue<Pair> queue=new LinkedList<>();

        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()){
            Pair pair=queue.poll();
            Node node=pair.node;
            int hd=pair.hd;
            if(!topViewMap.containsKey(hd)){
                topViewMap.put(hd, node.data);
            }

            if(node.left!=null){
                queue.add(new Pair(node.left, hd - 1));
            }
            if(node.right!=null){
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        System.out.println(topViewMap.values());
    }
}

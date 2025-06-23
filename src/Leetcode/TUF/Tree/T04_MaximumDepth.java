/*
package Leetcode.TUF.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class T04_MaximumDepth {
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        T04_MaximumDepth solution = new T04_MaximumDepth();
        int depth = solution.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }

    */
/*private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }*//*


    //using bfs
    private int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        int level=1;
        while (!queue.isEmpty()){

        }
    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
}
*/

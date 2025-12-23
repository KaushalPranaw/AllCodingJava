package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new CountCompleteTreeNodes().countNodes(root));

    }


    public int countNodes(TreeNode root) {
        /*
        In a complete binary tree:

        If left subtree height == right subtree height
        👉 Left subtree is a perfect binary tree

        If left height > right height
        👉 Right subtree is a perfect binary tree

        A perfect binary tree with height h has:
        nodes = 2^h - 1

        Instead of counting every node:

        Calculate left height
        Calculate right height

        If heights are equal:
        Left subtree is perfect → count instantly
        Recur on right subtree

        Else:
        Right subtree is perfect → count instantly
        Recur on left subtree
        This reduces work drastically.
        ⏱️ Time Complexity: O((log n)^2)
         */

        if(root==null){
            return 0;
        }

        int leftHeight=getLeftHeight(root);
        int rightHeight=getRightHeight(root);

        // If heights are same → perfect binary tree
        if (leftHeight == rightHeight) {
            //1 << h   ==   2^h
            //1 << 2 = 2^2=4
            //1 << 3 = 2^3 = 8
            //return (1 << leftHeight) - 1;
            // or
            return (int) Math.pow(2, leftHeight) - 1;
        }

        // Otherwise count root + left + right
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

}

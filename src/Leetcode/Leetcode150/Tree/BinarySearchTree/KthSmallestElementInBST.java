package Leetcode.Leetcode150.Tree.BinarySearchTree;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 2;

        KthSmallestElementInBST obj = new KthSmallestElementInBST();
        System.out.println(obj.kthSmallest(root, k));
    }

    int count = 0, res = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return res;
        }
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inorder(node.left, k);
        count++;
        if (count == k) {
            res = node.val;
        }
        inorder(node.right, k);
    }
}

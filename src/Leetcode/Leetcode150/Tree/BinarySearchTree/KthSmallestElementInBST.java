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

    int count = 0, result = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return result;
        }
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        inorder(root.right, k);
    }
}

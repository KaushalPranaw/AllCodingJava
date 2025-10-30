package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Max Depth of Example 1: " + solution.maxDepth(root1)); // Output: 3

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}

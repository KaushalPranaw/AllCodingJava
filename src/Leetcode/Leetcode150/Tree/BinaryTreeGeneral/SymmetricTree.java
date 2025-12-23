package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree solution = new SymmetricTree();

        // Example 1: Symmetric Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println("Is root1 symmetric? " + solution.isSymmetric(root1)); // Output: true

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode nodeLeft, TreeNode nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return true;
        }

        if (nodeLeft == null || nodeRight == null) {
            return false;
        }

        if (nodeLeft.val != nodeRight.val) {
            return false;
        }

        return isSymmetricHelper(nodeLeft.left, nodeRight.right)
                && isSymmetricHelper(nodeLeft.right, nodeRight.left);

    }
}

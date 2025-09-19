package Leetcode.Tree.BinaryTreeGeneral;

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
        if(root==null){
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }

        if(left==null || right==null){
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}

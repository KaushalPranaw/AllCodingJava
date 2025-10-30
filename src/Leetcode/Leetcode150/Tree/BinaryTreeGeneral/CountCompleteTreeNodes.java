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

    static int count = 0;

    public int countNodes(TreeNode root) {
        inorder(root);
        return count;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        count++;
        inorder(root.right);
    }
}

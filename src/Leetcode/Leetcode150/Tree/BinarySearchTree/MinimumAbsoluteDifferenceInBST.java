package Leetcode.Leetcode150.Tree.BinarySearchTree;

public class MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        MinimumAbsoluteDifferenceInBST obj = new MinimumAbsoluteDifferenceInBST();
        obj.getMinimumDifference(root);
        System.out.println(obj.min);

    }

    int min = Integer.MAX_VALUE;
    TreeNode prev;


    public int getMinimumDifference(TreeNode root) {

        inorderTrav(root);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void inorderTrav(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTrav(root.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(prev.val - root.val));
        }
        prev = root;

        inorderTrav(root.right);
    }


}

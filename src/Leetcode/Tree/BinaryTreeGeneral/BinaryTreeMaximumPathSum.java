package Leetcode.Tree.BinaryTreeGeneral;

import java.util.Map;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        //Input: root = [-10,9,20,null,null,15,7]
        //Output: 42
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));

    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));

        max = Math.max(max, node.val + leftSum + rightSum);

        return node.val + Math.max(leftSum, rightSum);

    }

    /*public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the maximum gain from the left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Calculate the price of the current path
        int priceNewPath = node.val + leftGain + rightGain;
        max = Math.max(max, priceNewPath);

        // Return the maximum gain if we continue the same path
        return node.val + Math.max(leftGain, rightGain);
    }*/
}

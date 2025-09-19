package Leetcode.Tree.BinaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorder solution = new ConstructBinaryTreeFromPreorderAndInorder();

        // Example 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        printTree(root1); // Output: 3 9 20 15 7
    }

    // Helper method to print the tree (inorder traversal)
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {

        if (is > ie || ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);
        int indexRoot = map.get(root.val);
        int numLeft = indexRoot - is;

        root.left = helper(preorder, ps + 1, ps + numLeft, inorder, is, indexRoot - 1, map);
        root.right = helper(preorder, ps + numLeft + 1, pe, inorder, indexRoot + 1, ie, map);
        return root;
    }


}

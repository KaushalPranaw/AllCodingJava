package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostOrder {
    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostOrder solution = new ConstructBinaryTreeFromInorderAndPostOrder();

        // Example 1
        int[] postorder1 = {9, 15, 7, 20, 3};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        printTree(root1); // Output: 3 9 20 15 7
    }

    // Helper method to print the tree (inorder traversal)
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
        System.out.println();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int indexRoot = map.get(root.val);
        int numLeft = indexRoot - is;

        root.left = helper(inorder, is, indexRoot - 1, postorder, ps, ps + numLeft - 1, map);
        root.right = helper(inorder, indexRoot + 1, ie, postorder, ps + numLeft, pe - 1, map);
        return root;
    }


}

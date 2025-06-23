package Leetcode.Tree.BinaryTreeGeneral;

public class LowestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Nodes for which we want to find the LCA
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1

        // Find the LCA
        LowestCommonAncestorOfBinaryTree solution = new LowestCommonAncestorOfBinaryTree();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        if (lca != null) {
            System.out.println(lca.val);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}

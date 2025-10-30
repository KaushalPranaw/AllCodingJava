package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        SameTree solution = new SameTree();
        System.out.println("Are p1 and q1 the same tree? " + solution.isSameTree(p1, q1)); // Output: true
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

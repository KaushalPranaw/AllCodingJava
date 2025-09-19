package Leetcode.Tree.BinaryTreeGeneral;

public class InvertBinaryTree {
    public static void main(String[] args) {
        /*Input: root = [4,2,7,1,3,6,9]
                Output: [4,7,2,9,6,3,1]*/
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode invertedRoot1 = solution.invertTree(root1);
        invertedRoot1.printTree(invertedRoot1);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

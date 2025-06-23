package Leetcode.Tree.BinaryTreeGeneral;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        //Input: root = [1,2,3]
        //Output: 12+13=25

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));

    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int curSum) {
        if (node == null) {
            return 0;
        }

        curSum = curSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return curSum;
        }

        return dfs(node.left, curSum) + dfs(node.right, curSum);
    }
}

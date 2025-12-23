package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

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

    int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}

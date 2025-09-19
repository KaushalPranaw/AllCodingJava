package Leetcode.Tree.BinaryTreeGeneral;

public class PathSum {
    public static void main(String[] args) {
        PathSum solution = new PathSum();

        // Create a sample binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println("Has path sum " + targetSum + "? " + result);

        //Test case 2: false
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        int targetSum2 = 1;
        boolean result2 = solution.hasPathSum(root2, targetSum2);
        System.out.println("Has path sum " + targetSum2 + "? " + result2);

        //Test case 3: true
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        int targetSum3 = 3;
        boolean result3 = solution.hasPathSum(root3, targetSum3);
        System.out.println("Has path sum " + targetSum3 + "? " + result3);

        //Test case 4: empty tree
        TreeNode root4 = null;
        int targetSum4 = 0;
        boolean result4 = solution.hasPathSum(root4, targetSum4);
        System.out.println("Has path sum " + targetSum4 + "? " + result4);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, targetSum);
    }

    private boolean hasPathSumHelper(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSumHelper(root.left, targetSum - root.val)
                || hasPathSumHelper(root.right, targetSum - root.val);
    }

}

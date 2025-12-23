package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /*
        Path shapes allowed:
        Single node
        node → left
        node → right
        left → node → right   ✅ (MOST IMPORTANT CASE)

        Key Idea
        At each node, we ask 2 questions:
        1️⃣ What is the maximum path sum passing THROUGH this node?
        This means:
        left contribution + node value + right contribution

        2️⃣ What is the maximum path sum going UP to parent?
        Parent can take only one side, not both.
        So we return:
        node value + max(left, right)

        Why ignore negative paths?
        If a child path gives negative sum, we discard it:
        Math.max(0, leftGain)
        Because adding a negative number reduces the total.
        👉 This can be the final answer

        Algorithm (DFS)

        Do postorder traversal
        Maintain a global max
        At each node:
        Get left & right gains
        Update global max
        Return best single path upward
         */

        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if(node==null){
            return 0;
        }

        // Ignore negative paths
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain=Math.max(0, dfs(node.right));

        // Case where path passes through this node
        int currentPathSum=node.val+leftGain+rightGain;

        // Update global max
        maxSum=Math.max(maxSum, currentPathSum);

        // Return max path going UP
        return node.val + Math.max(leftGain, rightGain);
    }
}

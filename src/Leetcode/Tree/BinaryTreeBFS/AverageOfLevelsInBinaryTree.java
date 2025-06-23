package Leetcode.Tree.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();
        List<Double> ans = solution.averageOfLevels(root);
        System.out.println("Avg view: " + ans);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            double sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add((sum / level));
        }
        return ans;
    }
}

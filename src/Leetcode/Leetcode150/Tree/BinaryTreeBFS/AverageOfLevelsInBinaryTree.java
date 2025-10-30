package Leetcode.Leetcode150.Tree.BinaryTreeBFS;

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
        List<Double> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            double sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add(sum / level);
        }
        return list;
    }
}

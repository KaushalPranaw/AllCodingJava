package Leetcode.TUF.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T03_LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        System.out.println(levelOrderTraversal(root));
    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(levelList);
        }
        return list;
    }

    // Changed from record to class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}

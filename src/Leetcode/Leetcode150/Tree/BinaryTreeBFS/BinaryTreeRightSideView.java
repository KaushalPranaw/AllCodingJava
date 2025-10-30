package Leetcode.Leetcode150.Tree.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        List<Integer> rightSide = solution.rightSideView(root);
        System.out.println("Right side view: " + rightSide);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < level; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add(cur.val);
        }
        return list;
    }
}

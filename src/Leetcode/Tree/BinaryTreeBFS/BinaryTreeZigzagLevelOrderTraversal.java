package Leetcode.Tree.BinaryTreeBFS;

import DesignPatterns.Structural.Proxy.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> ans = solution.levelOrder(root);
        System.out.println("level view: " + ans);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag=false;
        while (!queue.isEmpty()){
            int level=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode node= queue.poll();
                if(zigzag){
                    list.add(0, node.val);
                }else {
                    list.add(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            zigzag=!zigzag;
            ans.add(list);
        }
        return ans;
    }
}

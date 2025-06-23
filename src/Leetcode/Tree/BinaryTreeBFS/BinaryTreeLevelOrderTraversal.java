package Leetcode.Tree.BinaryTreeBFS;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(9);
        root.right.right = new TreeNode(4);

        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> ans = solution.levelOrder(root);
        System.out.println("level view: " + ans);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrap=new ArrayList<>();
        if(root==null){
            return wrap;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int level=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode node=q.poll();
                list.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            wrap.add(list);
        }
        return wrap;
    }
}

package Leetcode.Auto.Premium;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(2);

        System.out.println("Unbalanced BST (Inorder):");
        printInorder(root);
        System.out.println();
    }
    public static TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list=new ArrayList<>();
        inorder(root, list);

        return createBST(list, 0, list.size()-1);
    }

    private static TreeNode createBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(mid);
        root.left=createBST(list, left, mid-1);
        root.right=createBST(list, mid+1, right);
        return root;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

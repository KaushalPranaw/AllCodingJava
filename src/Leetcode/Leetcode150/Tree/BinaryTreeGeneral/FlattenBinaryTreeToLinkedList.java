package Leetcode.Leetcode150.Tree.BinaryTreeGeneral;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        // Creating a sample binary tree
        /*
               1
              / \
             2   5
            / \   \
           3   4   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Flattening the binary tree to a linked list
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        solution.flatten(root);

        // Printing the flattened tree (linked list)
        System.out.print("Flattened tree: ");
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
        System.out.println("null");
    }

    //Approach 1: Recursive (Postorder Traversal)
    /*TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }*/

    //Approach 2: Iterative (Using Stack)
    /*public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            stack.pop();

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }*/

    //Approach 3: Morris Traversal (Constant Space)
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode prev = cur.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}

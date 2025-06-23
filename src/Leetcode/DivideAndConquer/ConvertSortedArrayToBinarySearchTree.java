package Leetcode.DivideAndConquer;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree solution = new ConvertSortedArrayToBinarySearchTree();

        // Test case 1
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = solution.sortedArrayToBST(nums1);
        root1.printTree(root1);
        System.out.println();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = createTree(nums, l, m - 1);
        root.right = createTree(nums, m + 1, r);
        return root;
    }
}
package Leetcode.Leetcode150.Tree.SegmentTree;

import java.util.Arrays;

public class ST01_SegmentTree {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        ST01_SegmentTree st = new ST01_SegmentTree(arr);
        System.out.println(Arrays.toString(st.segTree));
    }

    private int[] segTree;
    private int n;

    public ST01_SegmentTree(int[] arr) {
        n = arr.length;
        segTree = new int[4 * n];// Using 4*n to avoid overflow in recursion
        buildTree(0, 0, n - 1, arr);
    }

    private void buildTree(int i, int l, int r, int[] arr) {
        //base case
        if (l == r) {
            segTree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(2 * i + 1, l, mid, arr);
        buildTree(2 * i + 2, mid + 1, r, arr);

        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }

}

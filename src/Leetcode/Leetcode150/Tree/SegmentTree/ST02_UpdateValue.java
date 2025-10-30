package Leetcode.Leetcode150.Tree.SegmentTree;

import java.util.Arrays;

public class ST02_UpdateValue {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        ST02_UpdateValue st = new ST02_UpdateValue(arr);
        System.out.println(Arrays.toString(st.segTree));
        st.updateQuery(2, 6);
        System.out.println(Arrays.toString(st.segTree));
    }

    private int[] segTree;
    private int n;

    public ST02_UpdateValue(int[] arr) {
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

    //update query
    private void updateQuery(int idx, int val) {
        updateQueryHelper(idx, val, 0, 0, n - 1);
    }

    private void updateQueryHelper(int idx, int val, int i, int l, int r) {
        //base case
        if (l == r) {
            segTree[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            updateQueryHelper(idx, val, 2 * i + 1, l, mid);
        } else {
            updateQueryHelper(idx, val, 2 * i + 2, mid + 1, r);
        }
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }

}

package Leetcode.Leetcode150.Tree.SegmentTree;

import java.util.Arrays;

public class ST04_QuerySumII {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        ST04_QuerySumII st = new ST04_QuerySumII(arr);
        System.out.println(Arrays.toString(st.segTree));
        System.out.println("Sum of range (1,4): " + st.rangeSum(1, 4));
        st.updateQuery(2, 6);
        System.out.println(Arrays.toString(st.segTree));
        System.out.println("Updated sum of range (1,4): " + st.rangeSum(1, 4));
    }

    private int[] segTree;
    private int n;

    public ST04_QuerySumII(int[] arr) {
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

    //Range sum query
    public int rangeSum(int start, int end) {
        return rangeSumHelper(start, end, 0, 0, n - 1);
    }

    private int rangeSumHelper(int start, int end, int i, int l, int r) {
        //out of bound case
        if (l > end || r < start) {
            return 0;
        }

        //inside case
        if (l >= start && r <= end) {
            return segTree[i];
        }

        //overlapping case
        //return query(left)+query(right);
        int mid = l + (r - l) / 2;
        return rangeSumHelper(start, end, 2 * i + 1, l, mid) +
                rangeSumHelper(start, end, 2 * i + 2, mid + 1, r);
    }

}

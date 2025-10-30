package Leetcode.Leetcode150.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new Combinations().combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> wrap = new ArrayList<>();
        combinations(wrap, new ArrayList<>(), 1, n, k);
        return wrap;
    }

    private void combinations(List<List<Integer>> wrapList, ArrayList<Integer> list, int start, int n, int k) {
        if (k == 0) {
            wrapList.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            combinations(wrapList, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}

package Leetcode.Leetcode150.Backtracking;

import CoreJava.OOPS.pillars.inheritance.A;

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

    /*private void combinations(List<List<Integer>> wrapList, ArrayList<Integer> list, int start, int n, int k) {
        if (k == 0) {
            wrapList.add(new ArrayList<>(list));
            return;
        }
        if (start > n) {
            return;
        }

        //phle temp me add krege
        list.add(start);
        //fir age call kr dege
        combinations(wrapList, list, start + 1, n, k - 1);

        //backtrack
        //remove from list
        list.remove(list.size() - 1);
        //call another number
        combinations(wrapList, list, start + 1, n, k);
    }*/

    //using for loop
    private void combinations(List<List<Integer>> wrapList, ArrayList<Integer> list, int start, int n, int k) {
        if (k == 0) {
            wrapList.add(new ArrayList<>(list));
            return;
        }
        if (start > n) {
            return;
        }

        //hum phle 1 le rhe hai aur fir aage ja rhe h by skipping 1
        //to that thing we can do using loop also
        for (int i = start; i <= n; i++) {
            //phle list me dalte
            list.add(i);
            combinations(wrapList, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
            //ab wo combination wala method likhne ki need ni hai, wo for loop se ho gya hai
        }
    }
}

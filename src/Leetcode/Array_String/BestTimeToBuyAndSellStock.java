package Leetcode.Array_String;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }
}

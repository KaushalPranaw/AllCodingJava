package Comp.CodeWithComplexity75.Array;

public class C02_BestTimetoBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new C02_BestTimetoBuyAndSellStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;

    }
}

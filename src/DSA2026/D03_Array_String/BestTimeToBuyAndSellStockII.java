package DSA2026.D03_Array_String;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        //Input: prices = [7,1,5,3,6,4]
        //Output: 7
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }
}

package DSA2026.D03_Array_String;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        //Input: prices = [7,1,5,3,6,4]
        //Output: 5
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}

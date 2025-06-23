package Leetcode.DP.DP04_Stocks;

public class DP35_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] Arr = {7, 1, 5, 3, 6, 4};

        System.out.println("The maximum profit by selling the stock is " +
                maximumProfit(Arr));
    }

    private static int maximumProfit(int[] arr) {
        int minPrice = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        return maxProfit;
    }
}

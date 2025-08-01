package xyz.basalto.arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int todayProfit = prices[i] - prices[i - 1];
            if (todayProfit > 0) {
                profit += todayProfit;
            }
        }

        return profit;
    }
}

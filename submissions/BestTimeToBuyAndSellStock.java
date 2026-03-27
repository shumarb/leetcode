// Question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minimumPrice = Integer.MAX_VALUE;
        int maximumProfit = 0;

        for (int price: prices) {
            // 1. Find lowest price so far.
            if (price < minimumPrice) {
                minimumPrice = price;
            }

            // 2. Selling at current price may generate largest profit
            // so compare and update maximum profit.
            if (price - minimumPrice > maximumProfit) {
                maximumProfit = price - minimumPrice;
            }
        }

        return maximumProfit;
    }
}

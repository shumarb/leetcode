// Question: https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/description/

class NumberOfSmoothDescentPeriodsOfAStock {
    public long getDescentPeriods(int[] prices) {
        // 1. Count first price.
        long totalDescentPeriods = 1;
        long currentDescentPeriods = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                currentDescentPeriods++;
            } else {
                currentDescentPeriods = 1;
            }
            totalDescentPeriods += currentDescentPeriods;
        }

        return totalDescentPeriods;
    }
}
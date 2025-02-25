// Question: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/

class FindPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        boolean isTest = false;

        for (int i = 0; i < prices.length - 1; i++) {
            boolean isStop = false;
            for (int j = i + 1; j < prices.length && !isStop; j++) {
                if (isTest) {
                    System.out.println("prices: " + Arrays.toString(prices));
                    System.out.println(" indices | i: " + i + ", j: " + j);
                    System.out.println(" prices | " + prices[i] + ", " + prices[j]);
                }
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    isStop = true;
                }
            }
        }

        return prices;
    }

    private boolean isAscending(int[] prices) {
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
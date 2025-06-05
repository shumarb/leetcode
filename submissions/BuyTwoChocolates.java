// Question: https://leetcode.com/problems/buy-two-chocolates/description/

class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        int minimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;
        boolean isTest = false;

        for (int price: prices) {
            if (price < minimum) {
                secondMinimum = minimum;
                minimum = price;
            } else if (price < secondMinimum) {
                secondMinimum = price;
            }
        }
        if (isTest) {
            System.out.println("prices: " + Arrays.toString(prices) + ", money: " + money);
            System.out.println("minimum: " + minimum + ", second minimum: " + secondMinimum);
        }

        /**
         1.  If the sum of 2 smallest prices <= money,
             then exactly 2 chocolates can be bought with money,
             so return the balance (money - sum of 2 smallest prices),
             else return money as it is impossible to buy those 2 chocolates without ending in debt.
         */
        return (minimum + secondMinimum <= money) ? (money - minimum - secondMinimum) : money;
    }
}
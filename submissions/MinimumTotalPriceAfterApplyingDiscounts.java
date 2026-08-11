// Question: https://leetcode.com/problems/minimum-total-price-after-applying-discounts/description/

class MinimumTotalPriceAfterApplyingDiscounts {
    public double minPrice(int[] prices, int[] discounts) {
        boolean isTest = false;
        double result = 0;
        int discountsIndex = discounts.length - 1;

        sort(discounts);
        sort(prices);
        if (isTest) {
            System.out.println("sorted prices: " + Arrays.toString(prices) + "\nsorted discounts: " + Arrays.toString(discounts));
            System.out.println("---------------------------------------------------------------------");
        }
        for (int i = prices.length - 1; i >= 0; i--) {
            double p = prices[i];

            if (discountsIndex < 0) {
                if (isTest) {
                    System.out.println(" * discountsIndex: " + discountsIndex + ", price: " + p + " -> add: " + p);
                }

            } else {
                p = (p * (100.0 - discounts[discountsIndex])) / 100.0;

                if (isTest) {
                    System.out.println(" * discountsIndex: " + discountsIndex + ", discount: " + discounts[discountsIndex] + "%, price: " + prices[i] + " -> add: " + p);
                }

                discountsIndex--;
            }

            result += p;
        }
        if (isTest) {
            System.out.println("---------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void sort(int[] arr) {
        int[] count;
        int j = 0;
        int largest = 0;

        for (int e: arr) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];

        for (int e: arr) {
            count[e]++;
        }
        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }
    }
}

// Question: https://leetcode.com/problems/apply-discount-every-n-orders/description/

class Cashier {
    private boolean isTest;
    private double discountedRate;
    private int[] price;
    private int[] product;
    private int largest;
    private int n;
    private int totalOrders;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        discountedRate = 1.0 - (discount / 100.0);
        isTest = false;
        largest = 0;
        price = new int[201];
        this.n = n;
        totalOrders = 0;

        Arrays.fill(price, -1);
        for (int i = 0; i < prices.length; i++) {
            largest = Math.max(largest, products[i]);
            price[products[i]] = prices[i];
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("price: " + Arrays.toString(Arrays.copyOfRange(price, 0, largest + 1)));
        }
    }

    public double getBill(int[] product, int[] amount) {
        boolean isDiscountApplied = false;
        double bill = 0;
        int total = amount.length;

        for (int i = 0; i < total; i++) {
            bill += amount[i] * price[product[i]];
        }
        if (++totalOrders % n == 0) {
            bill *= discountedRate;
            isDiscountApplied = true;
            totalOrders = 0;
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("product: " + Arrays.toString(product) + ", amount: " + Arrays.toString(amount) + "\nbill: " + bill);
            if (isDiscountApplied) {
                System.out.println(" * applied discount");
            }
        }

        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */

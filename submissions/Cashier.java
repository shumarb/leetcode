// Question: https://leetcode.com/problems/apply-discount-every-n-orders/description/

class Cashier {
    private boolean isTest;
    private int[] price;
    private int[] product;
    private int discount;
    private int largest;
    private int totalOrders;
    private long n;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        isTest = false;
        largest = 0;
        price = new int[1001];
        this.discount = discount;
        this.n = n;
        totalOrders = 0;

        Arrays.fill(price, -1);
        for (int i = 0; i < prices.length; i++) {
            largest = Math.max(largest, products[i]);
            price[products[i]] = prices[i];
        }
        if (isTest) {
            print();
        }
    }

    private void print() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("price: " + Arrays.toString(Arrays.copyOfRange(price, 0, largest + 1)));
    }

    public double getBill(int[] product, int[] amount) {
        boolean isDiscountApplied = false;
        double bill = 0;

        for (int i = 0; i < amount.length; i++) {
            bill += amount[i] * price[product[i]];
        }
        if (++totalOrders % n == 0) {
            isDiscountApplied = true;
            bill = bill * ((double) (100.0 - discount) / 100.0);
            totalOrders = 0;
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("product: " + Arrays.toString(product) + ", amount: " + Arrays.toString(amount) + "\nbill: " + bill);
            if (isDiscountApplied) {
                System.out.println(" * applied " + discount + "% discount");
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

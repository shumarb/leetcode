// Question: https://leetcode.com/problems/smallest-divisible-digit-product-i/description/

class SmallestDivisibleDigitProductOne {
    public int smallestNumber(int n, int t) {
        while (true) {
            if (getProductOfDigits(n) % t == 0) {
                return n;
            }
            n++;
        }
    }

    private int getProductOfDigits(int number) {
        int product = 1;
        while (number != 0) {
            product *= number % 10;
            number /= 10;
        }
        return product;
    }
}
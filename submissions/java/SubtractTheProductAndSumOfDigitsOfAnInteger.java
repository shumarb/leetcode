// Question: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/

class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int productOfDigits = 1;
        int sumOfDigits = 0;

        while (n != 0) {
            int digit = n % 10;
            sumOfDigits += digit;
            productOfDigits *= digit;
            n /= 10;
        }

        return productOfDigits - sumOfDigits;
    }
}
// Question: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/

class CheckDivisibiltyByDigitSumAndProduct {
    public boolean checkDivisibility(int n) {
        boolean isTest = false;
        int product = 1;
        int sum = 0;

        int nCopy = n;
        while (nCopy != 0) {
            int digit = nCopy % 10;
            product *= digit;
            sum += digit;
            nCopy /= 10;
        }
        if (isTest) {
            System.out.println("n: " + n + "\nsum: " + sum + "\nproduct: " + product);
        }

        return n % (sum + product) == 0;
    }
}
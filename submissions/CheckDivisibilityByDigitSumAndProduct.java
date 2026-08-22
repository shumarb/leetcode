// Question: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/

class CheckDivisibilityByDigitSumAndProduct {
    public boolean checkDivisibility(int n) {
        int digitProduct = 1;
        int digitSum = 0;
        int nCopy = n;

        while (nCopy > 0) {
            int digit = nCopy % 10;
            digitProduct *= digit;
            digitSum += digit;
            nCopy /= 10;
        }

        return n % (digitSum + digitProduct) == 0;
    }
}
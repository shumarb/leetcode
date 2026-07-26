// Question: https://leetcode.com/problems/maximum-product-of-two-digits/description/

class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        boolean isTest = false;
        int largestDigit = 0;
        int nCopy = n;
        int secondLargestDigit = 0;

        while (nCopy > 0) {
            int digit = nCopy % 10;

            if (digit >= largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = digit;

            } else if (digit >= secondLargestDigit) {
                secondLargestDigit = digit;
            }

            nCopy /= 10;
        }
        if (isTest) {
            System.out.println("n: " + n + "\nlargestDigit: " + largestDigit + "\nsecondLargestDigit: " + secondLargestDigit);
        }

        return largestDigit * secondLargestDigit;
    }
}
